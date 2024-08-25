package com.sportswear.sportswear.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ClientDTO {
    @NotNull(message = "Name should not be null!")
    private String name;

    @NotNull(message = "Last name should not be null!")
    private String lastName;

    private String middleName;

    @NotNull(message = "Last name should not be null!")
    private String phone;

    @NotNull(message = "Last name should not be null!")
    @Email(message = "Wrong email format!")
    private String email;

    @Past(message = "Birth date could not be in future!")
    private LocalDateTime birthDate;

    private List<UUID> deliveryAddresses;

    private List<UUID> orders;
}
