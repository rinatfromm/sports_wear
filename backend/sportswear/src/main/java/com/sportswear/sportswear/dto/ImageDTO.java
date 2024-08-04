package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ImageDTO {
    private UUID id;

    @NotNull(message = "Image URL should not be null!")
    private String imageURL;
}
