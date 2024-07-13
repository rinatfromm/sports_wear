package com.sportswear.sportswear.dto;

import com.sportswear.sportswear.entity.Client;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeliveryAddressDTO {
    private UUID id;

    @NotNull(message = "Client should not be null!")
    private Client client;

    @NotNull(message = "Country should not be null!")
    @NotBlank(message = "Country should not be empty!")
    private String country;

    @NotNull(message = "City should not be null!")
    @NotBlank(message = "City should not be empty!")
    private String city;

    @NotNull(message = "Street should not be null!")
    @NotBlank(message = "Street should not be empty!")
    private String street;

    @NotNull(message = "House number should not be null!")
    @NotBlank(message = "House number should not be empty!")
    private String houseNumber;

    @NotNull(message = "Floor should not be null!")
    @NotBlank(message = "Floor should not be empty!")
    private String floor;

    @NotNull(message = "Apartment should not be null!")
    private Integer apartment;

    @NotNull(message = "Active should not be null!")
    @AssertTrue(message = "Active is wrong!")
    private Boolean active;

    private LocalDateTime created;

    private  LocalDateTime updated;
}
