package com.sportswear.sportswear.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ClientGetDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;
    private LocalDateTime birthDate;
}
