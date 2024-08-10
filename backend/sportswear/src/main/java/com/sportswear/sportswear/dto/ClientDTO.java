package com.sportswear.sportswear.dto;

import com.sportswear.sportswear.entity.PersonalInfo;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ClientDTO {
    private UUID id;

    @NotNull(message = "Personal info should not be null!")
    private PersonalInfo personalInfo;

    @NotNull(message = "Active should not be null!")
    @AssertTrue(message = "Active is wrong!")
    private boolean active;

    private LocalDateTime created;

    private LocalDateTime updated;
}
