package com.sportswear.sportswear.converter;

import com.sportswear.sportswear.dto.PersonalInfoDTO;
import com.sportswear.sportswear.entity.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonalInfoDTOConverter {
    private final ModelMapper modelMapper;

    public PersonalInfo convertDTOToPersonalInfo(PersonalInfoDTO personalInfoDTO) {
        return modelMapper.map(personalInfoDTO, PersonalInfo.class);
    }

    public PersonalInfoDTO convertPersonalInfoToDTO(PersonalInfo personalInfo) {
        return modelMapper.map(personalInfo, PersonalInfoDTO.class);
    }
}
