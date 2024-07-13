package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, UUID> {
    Basket findAllById(UUID id);
}