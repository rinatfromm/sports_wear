package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
    Image findAllById(UUID id);
}
