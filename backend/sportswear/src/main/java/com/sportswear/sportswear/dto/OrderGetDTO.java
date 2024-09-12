package com.sportswear.sportswear.dto;

import com.sportswear.sportswear.entity.Client;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderGetDTO {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Client client;
}
