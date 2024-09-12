package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ImageDTO {
    private UUID id;

    @NotNull(message = "Item id should not be null!")
    private UUID item;
}
