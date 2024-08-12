package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ImageDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ImageService {
    ImageDTO uploadImage(UUID id, MultipartFile image) throws IOException;
    Resource downloadImage(UUID imageId) throws IOException;
    ImageDTO getImageById(UUID id);
    List<ImageDTO> getAllImagesByItemId(UUID id);
    List<ImageDTO> getAllImages();
    ImageDTO updateImage(ImageDTO imageDTO);
    String deleteImageById(UUID id);
}
