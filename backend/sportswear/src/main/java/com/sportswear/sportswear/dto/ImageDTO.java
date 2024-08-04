package com.sportswear.sportswear.dto;

import com.sportswear.sportswear.entity.Item;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ImageDTO {
    private UUID id;

//    @NotNull(message = "Item id should not be null!")
//    private Item itemId;

    @NotNull(message = "Image URL should not be null!")
    private String imageURL;
}
