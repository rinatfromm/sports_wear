package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ItemDTO {
    private UUID id;

    @NotNull(message = "Name should not be null!")
    @NotBlank(message = "Name should not be empty!")
    private String name;

    @NotNull(message = "Category should not be null!")
    @NotBlank(message = "Category should not be empty!")
    private String category;

    @NotNull(message = "Size should not be null!")
    @NotBlank(message = "Size should not be empty!")
    private String size;

    @NotNull(message = "Price should not be empty!")
    @Min(value = 0, message = "Price should be greater than 0!")
    private BigDecimal price;

    @NotNull(message = "Weight should not be empty!")
    @Min(value = 0, message = "Weight should be greater than 0!")
    private BigDecimal weight;

    @NotNull(message = "Color should not be null!")
    @NotBlank(message = "Color should not be empty!")
    private String color;

    @NotNull(message = "In stock should not be null!")
    @Min(value = 0, message = "In stock should be greater than 0!")
    private Integer inStock;

    private List<UUID> images;

    private LocalDateTime created;

    private LocalDateTime updated;
}
