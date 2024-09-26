package com.sportswear.sportswear.dto;

import com.sportswear.sportswear.entity.Client;
import com.sportswear.sportswear.entity.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderGetDTO {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Client client;
    private List<OrderItem> orderItems;
}
