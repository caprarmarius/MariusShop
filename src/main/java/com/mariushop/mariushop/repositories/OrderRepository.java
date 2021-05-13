package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Integer> {
}
