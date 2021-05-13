package com.mariushop.mariushop.controllers;

import com.mariushop.mariushop.dtos.StockDTO;
import com.mariushop.mariushop.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mariushop-frontend.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/stocks")
public class StockController {

    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDTO newProduct(@RequestBody StockDTO stockDTO) {
        return stockService.createStock(stockDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StockDTO> stockDTOList() {
        return stockService.getAllStocks();
    }
}
