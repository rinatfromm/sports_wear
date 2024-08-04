package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
    Image findAllById(UUID id);

    @Query("SELECT im FROM Image im " +
            "WHERE im.itemId = :id ")
    List<Image> getAllByItemId(UUID id);
}
