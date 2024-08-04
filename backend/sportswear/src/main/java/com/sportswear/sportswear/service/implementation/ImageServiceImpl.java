package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.repository.ImageRepository;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageDTOConverter imageDTOConverter;

    @Value(value = "${image.path}")
    private String imagePath;

    @Override
    @Transactional
    public void uploadImage(MultipartFile image) throws IOException {
        UUID imageId = UUID.randomUUID();
        String imageName = imageId + ".jpg";
        String imageUrl = imagePath + imageName;
        Image imageDTO = new Image();
        imageDTO.setId(imageId);
        //imageDTO.setItemId();
        imageRepository.save(imageDTO);
        Files.write(Paths.get(imageUrl), image.getBytes());
        log.info("Upload image.");
    }

    @Override
    @Transactional
    public Image getImageById(UUID id) {
        log.info("Get image by id.");
        return imageRepository.findAllById(id);
    }

    @Override
    @Transactional
    public List<Image> getAllImagesByItemId(UUID id) {
        return imageRepository.getAllByItemId(id);
    }
    @Override
    @Transactional
    public List<Image> getAllImages() {
        log.info("Get all images.");
        return imageRepository.findAll();
    }

    @Override
    @Transactional
    public void updateImageById(ImageDTO imageDTO) {
        Image image = imageDTOConverter.convertDTOToImage(imageDTO);
        imageRepository.save(image);
        log.info("Update image by id.");
    }

    @Override
    @Transactional
    public void deleteImageById(UUID id) {
        String imageUrl = imagePath + id + ".jpg";
        try {
            Files.delete(Paths.get(imageUrl));
            imageRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't delete file! File not found!");
        }
    }
}
