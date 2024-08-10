package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

}
