package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.ImageDTO;
import com.sportswear.sportswear.entity.Image;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ImageDTOConverter {
    private final ModelMapper modelMapper;

    public Image convertDTOToImage(ImageDTO imageDTO) {
        return modelMapper.map(imageDTO, Image.class);
    }

    public ImageDTO convertImageToDTO(Image image) {
        return modelMapper.map(image, ImageDTO.class);
    }

    public List<ImageDTO> convertImagesToDTOs(List<Image> images) {
        List<ImageDTO> imageDTOs = new LinkedList<>();
        for (Image image : images) {
            imageDTOs.add(modelMapper.map(image, ImageDTO.class));
        }
        return imageDTOs;
    }
}
