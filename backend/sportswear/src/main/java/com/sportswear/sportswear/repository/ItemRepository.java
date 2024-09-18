package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
    Item findAllById(UUID id);

    @Query("SELECT it FROM Item it " +
            "WHERE it.name = :itemName ")
    List<Item> findAllByName(String itemName);
}
