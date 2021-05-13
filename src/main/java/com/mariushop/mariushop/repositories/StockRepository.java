package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findAllByLocation_Id(Integer id);

    Optional<Stock> findStockByProductProductIdAndLocation_Id(Integer productID, Integer locationID);

    List<Stock> findStockByProductProductId(Integer productID);
}

