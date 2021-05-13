package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    Optional<ProductCategory> findByName(String name);
}
