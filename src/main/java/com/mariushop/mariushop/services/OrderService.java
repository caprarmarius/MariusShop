package com.mariushop.mariushop.services;

import com.mariushop.mariushop.dtos.AddressDTO;
import com.mariushop.mariushop.dtos.OrderDTO;
import com.mariushop.mariushop.dtos.StockDTO;
import com.mariushop.mariushop.entities.Address;
import com.mariushop.mariushop.entities.Location;
import com.mariushop.mariushop.entities.Order;
import com.mariushop.mariushop.entities.User;
import com.mariushop.mariushop.exceptions.OrderNotFoundException;
import com.mariushop.mariushop.mappers.OrderDetailMapper;
import com.mariushop.mariushop.mappers.OrderMapper;
import com.mariushop.mariushop.repositories.AddressRepository;
import com.mariushop.mariushop.repositories.LocationRepository;
import com.mariushop.mariushop.repositories.OrderRepository;
import com.mariushop.mariushop.strategies.DeliveryStrategyInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final AddressRepository addressRepository;
    private final LocationRepository locationRepository;
    private final DeliveryStrategyInterface deliveryStrategyInterface;
    private final StockService stockService;
    private final UserService userService;

    public OrderDTO getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return orderMapper.mapOrderToOrderDTO(orderOptional.get());
        } else {
            throw new OrderNotFoundException("This order doesn't exist");
        }
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        List<StockDTO> orderedProducts = deliveryStrategyInterface.doAlgorithm(orderDTO.getProductsList());
        User user = userService.findUserByUsername(orderDTO.getUserId());
        Order order = Order.builder()
                .deliveryLocation(this.testLocationExistence(orderDTO.getDeliveryLocation().getAddressCity(), orderDTO.getDeliveryLocation()))
                .createdAt(LocalDateTime.now())
                .user(user)
                .orderDetail(orderDetailMapper.mapOrderDetailListDtoToOrderDetailList(orderDTO.getProductsList()))
                .shippedFrom(locationRepository.findLocationById(2))
                .build();

        order.getOrderDetail().forEach(orderDetail -> orderDetail.setOrder(order));
        orderRepository.save(order);
        orderedProducts.forEach(stockService::updateStock);
        return orderMapper.mapOrderToOrderDTO(order);
    }

    public Address testAddressExistence(String country, String city, String street) {
        Optional<Address> addressOptional = addressRepository.findByCountryAndAndCityAndStreet(country, city, street);
        Address address = null;
        if (addressOptional.isPresent()) {
            address = addressOptional.get();
        } else {
            address = new Address();
            address.setCountry(country);
            address.setCity(city);
            address.setStreet(street);
            addressRepository.save(address);
        }
        return address;
    }

    public Location testLocationExistence(String name, AddressDTO addressDTO) {
        Optional<Location> locationOptional = locationRepository.findByAddress_CountryAndAddress_CityAndAddress_Street
                (addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet());
        Location location = null;

        if (locationOptional.isPresent()) {
            location = locationOptional.get();
        } else {
            location = new Location();
            location.setName(name);
            location.setAddress(
                    this.testAddressExistence(addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet()));
            locationRepository.save(location);
        }
        return location;
    }

    public List<OrderDTO> getOrders() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orderRepository.findAll())
            orderDTOS.add(orderMapper.mapOrderToOrderDTO(order));
        return orderDTOS;
    }
}
