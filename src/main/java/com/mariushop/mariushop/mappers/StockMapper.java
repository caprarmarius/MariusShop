package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.StockDTO;
import com.mariushop.mariushop.entities.Stock;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public StockDTO mapStockToStockDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .locationID(stock.getLocation().getId())
                .productID(stock.getProduct().getProductId())
                .build();
    }

    public List<StockDTO> mapStockListToStockDTOList(List<Stock> stockList) {
        return stockList.stream().map(this::mapStockToStockDTO).collect(Collectors.toList());
    }
}
