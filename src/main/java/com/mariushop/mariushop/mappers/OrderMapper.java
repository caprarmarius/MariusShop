package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.OrderDTO;
import com.mariushop.mariushop.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;
    private final AddressMapper addressMapper;

    public OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .deliveryLocation(addressMapper.mapAddressToAddressDTO(order.getDeliveryLocation().getAddress()))
                .orderTimestamp(order.getCreatedAt())
                .userId(order.getUser().getUsername())
                .productsList(orderDetailMapper.mapOrderDetailListToOrderDetailDtoList(order.getOrderDetail()))
                .build();
    }
}
