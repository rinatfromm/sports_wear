package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.ImageDTOConverter;
import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import com.sportswear.sportswear.repository.ImageRepository;
import com.sportswear.sportswear.service.interfaces.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageDTOConverter imageDTOConverter;

    @Override
    @Transactional
    public void createImage(ImageDTO imageDTO) {
        imageRepository.save(imageDTOConverter.convertDTOToImage(imageDTO));
        log.info("Create image.");
    }

    @Override
    @Transactional
    public ImageDTO getImageById(UUID id) {
        log.info("Get all images.");
        return imageDTOConverter.convertImageToDTO(imageRepository.findAllById(id));
    }

    @Override
    @Transactional
    public List<ImageDTO> getAllImages() {
        List<Image> images = imageRepository.findAll();
        log.info("Get all images.");
        return imageDTOConverter.convertImagesToDTOs(images);
    }

    @Override
    @Transactional
    public void updateImageById(ImageDTO imageDTO) {
        Image image = imageDTOConverter.convertDTOToImage(imageDTO);
        imageRepository.save(image);
        log.info("Update image by id.");
    }
}
