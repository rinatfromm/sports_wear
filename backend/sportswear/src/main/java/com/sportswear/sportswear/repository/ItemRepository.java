package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    Item findAllById(UUID id);
}
