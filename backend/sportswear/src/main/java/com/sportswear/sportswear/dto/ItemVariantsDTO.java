package com.sportswear.sportswear.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ItemVariantsDTO {
    private UUID id;
    private String name;
    private String category;

    private List<VariantsDTO> variantsDTO;
}
