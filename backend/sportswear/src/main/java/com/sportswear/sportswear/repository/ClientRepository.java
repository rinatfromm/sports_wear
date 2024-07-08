package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findAllById(UUID uuid);
}