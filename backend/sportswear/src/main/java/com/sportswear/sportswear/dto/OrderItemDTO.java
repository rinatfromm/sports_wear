package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDTO {
    private UUID id;

    @NotNull(message = "Order Id should not be null!")
    private UUID orderId;

    @NotNull(message = "Item should not be null!")
    private UUID itemId;

    @NotNull(message = "Quantity should not be null!")
    @Min(value = 0, message = "Quantity should not be less zen zero!")
    private Integer quantity;
}
