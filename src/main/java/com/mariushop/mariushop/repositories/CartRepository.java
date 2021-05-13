package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    void deleteCartByProductIdAndUser_Username(Integer id, String username);
    void deleteCartByUser_Username(String username);
}
