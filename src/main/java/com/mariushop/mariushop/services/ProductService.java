package com.mariushop.mariushop.services;

import com.mariushop.mariushop.dtos.ProductDTO;
import com.mariushop.mariushop.entities.Product;
import com.mariushop.mariushop.entities.ProductCategory;
import com.mariushop.mariushop.exceptions.ProductNotFoundException;
import com.mariushop.mariushop.mappers.ProductMapper;
import com.mariushop.mariushop.repositories.ProductCategoryRepository;
import com.mariushop.mariushop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = Product.builder().name(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .weight(productDTO.getWeight())
                .image(productDTO.getImage())
                .productCategory(this.testCategoryExistence(productDTO.getCategoryName(), productDTO.getCategoryDescription()))
                .build();
        productRepository.save(product);
        return productMapper.mapProductToProductDto(product);
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        if (productRepository.findById(id).isPresent()) {
            Product existingProduct = productRepository.findById(id).get();
            existingProduct.setName(productDTO.getProductName());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setWeight(productDTO.getWeight());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setImage(productDTO.getImage());
            existingProduct.setProductCategory(this.testCategoryExistence(productDTO.getCategoryName(), productDTO.getCategoryDescription()));

            Product updatedProduct = productRepository.save(existingProduct);
            return productMapper.mapProductToProductDto(updatedProduct);
        } else {
            throw new ProductNotFoundException("This product doesn't exist");
        }
    }

    public void deleteProductById(Integer productId) throws ProductNotFoundException {
        productRepository.deleteById(productId);
    }

    public ProductDTO getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            return productMapper.mapProductToProductDto(productOptional.get());
        } else {
            throw new ProductNotFoundException("This product doesn't exist");
        }
    }

    public List<ProductDTO> getProducts() {
        List<ProductDTO> productList = new ArrayList<>();
        for (Product p : productRepository.findAll()) {
            productList.add(productMapper.mapProductToProductDto(p));
        }
        return productList;
    }

    public ProductCategory testCategoryExistence(String categoryName, String categoryDescription) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findByName(categoryName);
        ProductCategory prod = null;

        if (productCategory.isPresent()) {
            prod = productCategory.get();
        } else {
            prod = new ProductCategory();
            prod.setName(categoryName);
            prod.setDescription(categoryDescription);
            productCategoryRepository.save(prod);
        }
        return prod;
    }
}
