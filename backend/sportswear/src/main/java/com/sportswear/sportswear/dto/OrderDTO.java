package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {
    private UUID id;

    @NotNull(message = "Client id should not be null!")
    private UUID clientId;
}
