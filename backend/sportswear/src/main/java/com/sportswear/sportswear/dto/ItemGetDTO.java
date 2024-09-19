package com.sportswear.sportswear.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class ItemGetDTO {
    private UUID id;
    private String name;
    private String category;
    private String size;
    private BigDecimal price;
    private BigDecimal weight;
    private String color;
    private Integer inStock;

    private List<String> imageURLs;
}