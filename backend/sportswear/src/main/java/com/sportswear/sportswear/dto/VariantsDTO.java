package com.sportswear.sportswear.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class VariantsDTO {
    private UUID variantId;
    private String size;
    private String color;
    private Integer quantity;
    private BigDecimal price;

    private List<String> imageURLs;
}
