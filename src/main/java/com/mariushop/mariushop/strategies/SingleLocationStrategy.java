package com.mariushop.mariushop.strategies;

import com.mariushop.mariushop.dtos.OrderDetailDTO;
import com.mariushop.mariushop.dtos.StockDTO;
import com.mariushop.mariushop.entities.Location;
import com.mariushop.mariushop.entities.Stock;
import com.mariushop.mariushop.exceptions.ProductsNotAvailableException;
import com.mariushop.mariushop.repositories.LocationRepository;
import com.mariushop.mariushop.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

public class SingleLocationStrategy implements DeliveryStrategyInterface {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<StockDTO> doAlgorithm(List<OrderDetailDTO> requested) {

        List<Location> locationList = locationRepository.findAll();
        List<StockDTO> stockList = new ArrayList<>();

        for (Location location : locationList) {
            List<Stock> locationStock = stockRepository.findAllByLocation_Id(location.getId());

            stockList.clear();

            for (Stock currentStock : locationStock) {
                for (OrderDetailDTO requestedStock : requested) {
                    if (currentStock.getProduct().getProductId().equals(requestedStock.getProductId()) && requestedStock.getQuantity() < currentStock.getQuantity()) {
                        stockList.add(
                                StockDTO.builder()
                                        .productID(requestedStock.getProductId())
                                        .locationID(location.getId())
                                        .quantity(requestedStock.getQuantity())
                                        .build()
                        );
                        if (stockList.size() == requested.size())
                            return stockList;
                    }
                }
            }
        }
        throw new ProductsNotAvailableException("Products: " + requested.toString() + " not available in a single location");
    }
}
