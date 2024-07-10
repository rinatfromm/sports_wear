package com.sportswear.sportswear.service.implementation;

import com.sportswear.sportswear.converter.PersonalInfoDTOConverter;
import com.sportswear.sportswear.dto.PersonalInfoDTO;
import com.sportswear.sportswear.entity.PersonalInfo;
import com.sportswear.sportswear.repository.PersonalInfoRepository;
import com.sportswear.sportswear.service.interfaces.PersonalInfoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private final PersonalInfoRepository personalInfoRepository;
    private final PersonalInfoDTOConverter personalInfoDTOConverter;

    @Override
    @Transactional
    public void createPersonalInfo(@RequestBody @Valid PersonalInfoDTO personalInfoDTO) {
        personalInfoRepository.save(personalInfoDTOConverter.convertDTOToPersonalInfo(personalInfoDTO));
        log.info("Create personal info.");
    }

    @Override
    public PersonalInfoDTO getPersonalInfoById(UUID id) {
        log.info("Get personal info by id.");
        return personalInfoDTOConverter.convertPersonalInfoToDTO(personalInfoRepository.findAllById(id));
    }

    @Override
    public void updatePersonalInfoById(PersonalInfoDTO personalInfoDTO) {
        PersonalInfo personalInfo = personalInfoDTOConverter.convertDTOToPersonalInfo(personalInfoDTO);
        personalInfoRepository.save(personalInfo);
        log.info("Update personal info by id.");
    }
}
