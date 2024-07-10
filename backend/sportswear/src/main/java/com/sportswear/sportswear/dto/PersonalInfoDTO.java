package com.sportswear.sportswear.dto;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PersonalInfoDTO {
    private UUID id;

    @NotNull(message = "Name should not be null!")
    @NotBlank(message = "Name should not be empty!")
    private String name;

    @NotNull(message = "Last name should not be null!")
    @NotBlank(message = "Last name should not be empty!")
    private String lastName;

    private String middleName;

    @NotBlank(message = "Phone number should not be empty!")
    @NotNull(message = "Phone number should not be null!")
    @Size(min = 9, max = 18, message = "Phone number should be in range " +
            "from 9 to 18 digits!")
    @Pattern(regexp = "^(?:[0-9]+[-. ()]*)+$",
            message = "Invalid hot line number!")
    private String phone;

    @Email(message = "Wrong email format!")
    private String email;

    @NotNull(message = "Birth date should not be null!")
    @Past(message = "Birth date must be in the past!")
    private LocalDateTime birthDate;

    private LocalDateTime created;

    private  LocalDateTime updated;
}
