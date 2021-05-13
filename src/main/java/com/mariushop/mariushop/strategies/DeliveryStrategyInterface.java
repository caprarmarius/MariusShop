package com.mariushop.mariushop.strategies;

import com.mariushop.mariushop.dtos.OrderDetailDTO;
import com.mariushop.mariushop.dtos.StockDTO;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface DeliveryStrategyInterface {

    List<StockDTO> doAlgorithm(List<OrderDetailDTO> orderDetailDTOList);
}
