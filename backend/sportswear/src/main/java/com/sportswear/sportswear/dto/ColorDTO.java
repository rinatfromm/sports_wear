package com.sportswear.sportswear.dto;

import lombok.Data;

import java.util.List;

@Data
public class ColorDTO {
    String color;
    List<SizeDTO> sizeDTOs;
}
