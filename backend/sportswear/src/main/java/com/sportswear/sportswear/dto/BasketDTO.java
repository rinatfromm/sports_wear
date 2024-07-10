package com.sportswear.sportswear.dto;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BasketDTO {
    private UUID id;

    @NotNull(message = "Items id should not be null!")
    private UUID itemsId;

    @NotNull(message = "Quantity should not be null!")
    @Min(value = 0, message = "Quantity should not be less zen zero!")
    private Integer quantity;
}
