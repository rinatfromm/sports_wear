package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, UUID> {
    DeliveryAddress findAllById(UUID uuid);
}
