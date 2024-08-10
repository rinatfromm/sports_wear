package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderDTO {
    private UUID id;

    @NotNull(message = "Client id should not be null!")
    private UUID clientId;

    private LocalDateTime created;

    private LocalDateTime updated;
}
