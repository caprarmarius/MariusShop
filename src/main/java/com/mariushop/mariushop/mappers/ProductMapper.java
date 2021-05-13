package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.ProductDTO;
import com.mariushop.mariushop.entities.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    public ProductDTO mapProductToProductDto(Product product) {
        return ProductDTO.builder()
                .productName(product.getName())
                .id(product.getProductId())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryDescription(product.getProductCategory().getDescription())
                .categoryName(product.getProductCategory().getName())
                .weight(product.getWeight())
                .image(product.getImage())
                .build();
    }
}
