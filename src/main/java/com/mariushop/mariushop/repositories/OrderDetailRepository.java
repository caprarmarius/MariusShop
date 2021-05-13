package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
