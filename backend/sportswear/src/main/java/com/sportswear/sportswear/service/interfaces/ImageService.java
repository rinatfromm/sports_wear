package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ImageDTO;

import java.util.List;
import java.util.UUID;

public interface ImageService {
    void createImage(ImageDTO imageDTO);
    ImageDTO getImageById(UUID id);
    List<ImageDTO> getAllImages();
    void updateImageById(ImageDTO imageDTO);
}
