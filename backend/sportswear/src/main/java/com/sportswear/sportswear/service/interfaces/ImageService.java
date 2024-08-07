package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ImageService {
    void uploadImage(UUID id, MultipartFile image) throws IOException;
    Resource downloadImage(UUID imageId) throws IOException;
    Image getImageById(UUID id);
    List<Image> getAllImagesByItemId(UUID id);
    List<Image> getAllImages();
    void updateImageById(ImageDTO imageDTO);
    void deleteImageById(UUID id);
}
