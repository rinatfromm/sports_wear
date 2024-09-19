package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.repository.ImageRepository;
import com.sportswear.sportswear.repository.ItemRepository;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageDTOConverter imageDTOConverter;
    private final ItemRepository itemRepository;

    @Value(value = "${image.path}")
    private String imagePath;

    @Value(value = "${image.type}")
    private String imageType;

    @Override
    @Transactional
    public ImageDTO uploadImage(UUID id, MultipartFile imageFile) throws IOException {
//        Item item = itemRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Item not found!"));
        UUID imageId = UUID.randomUUID();
        String imageName = imageId + imageType;
        String imageUrl = imagePath + imageName;
        Image dbImage = new Image();
        dbImage.setId(imageId);
        dbImage.setItemId(id);
        Image image = imageRepository.save(dbImage);
        Files.write(Paths.get(imageUrl), imageFile.getBytes());
        log.info("Upload image. id " + id);
        return imageDTOConverter.convertImageToDTO(image);
    }

    @Override
    @Transactional
    public Resource downloadImage(UUID imageId) throws IOException {
        // Retrieve the image entity from the database
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new IllegalArgumentException("Image not found"));

        // Construct the file path
        Path filePath = Path.of(imagePath + File.separator + image.getId() + imageType);
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new IOException("Could not read file: " + image.getId());
        }
    }

    // Test
    @Value("${server.port}")
    private int serverPort;

    @Override
    public String downloadImageTest(UUID imageId) {
        return "http://localhost:" + serverPort + "/images/" + imageId + imageType;
//        return "http://localhost:" + serverPort + imagePath + imageId + imageType;
    }

    @Override
    @Transactional
    public ImageDTO getImageById(UUID id) {
        Image image = imageRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Image does not exist! id " + id));
        log.info("Get image. id " + id);
        return imageDTOConverter.convertImageToDTO(image);
    }

    @Override
    @Transactional
    public List<ImageDTO> getAllImagesByItemId(UUID id) {
//        return imageDTOConverter.convertImagesToDTOs(imageRepository.getAllByItemId(id));
        return null;
    }

    @Override
    @Transactional
    public List<ImageDTO> getAllImages() {
        log.info("Get all images.");
        return imageDTOConverter.convertImagesToDTOs(imageRepository.findAll());
    }

    @Override
    @Transactional
    public ImageDTO updateImage(ImageDTO imageDTO) {
        if (!imageRepository.existsById(imageDTO.getId())) {
            throw new NoSuchElementException("Could not update non existing order!");
        }
        Image image = imageRepository.save(imageDTOConverter.convertDTOToImage(imageDTO));
        log.info("Update image.");
        return imageDTOConverter.convertImageToDTO(image);
    }

    @Override
    @Transactional
    public String deleteImageById(UUID id) {
        String imageUrl = imagePath + id + ".jpg";
        try {
            Files.delete(Paths.get(imageUrl));
            imageRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't delete file! File not found!");
        }
        return "Image deleted! id " + id;
    }
}
