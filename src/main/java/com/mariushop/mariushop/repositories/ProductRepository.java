package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductId(Integer id);
}
