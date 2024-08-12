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

import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private final PersonalInfoRepository personalInfoRepository;
    private final PersonalInfoDTOConverter personalInfoDTOConverter;

    @Override
    @Transactional
    public PersonalInfoDTO createPersonalInfo(PersonalInfoDTO personalInfoDTO) {
        PersonalInfo personalInfo = personalInfoRepository.save(personalInfoDTOConverter.convertDTOToPersonalInfo(personalInfoDTO));
        log.info("Create personal info.");
        return personalInfoDTOConverter.convertPersonalInfoToDTO(personalInfo);
    }

    @Override
    public PersonalInfoDTO getPersonalInfoById(UUID id) {
        PersonalInfo personalInfo = personalInfoRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Personal info does not exist!"));
        log.info("Get personal info. id " + id);
        return personalInfoDTOConverter.convertPersonalInfoToDTO(personalInfo);
    }

    @Override
    public PersonalInfoDTO updatePersonalInfoById(PersonalInfoDTO personalInfoDTO) {
        if (!personalInfoRepository.existsById(personalInfoDTO.getId())) {
            new NoSuchElementException("Could not update non existing personal info!");
        }
        PersonalInfo personalInfo = personalInfoRepository
                .save(personalInfoDTOConverter.convertDTOToPersonalInfo(personalInfoDTO));
        log.info("Update personal info by id.");
        return personalInfoDTOConverter.convertPersonalInfoToDTO(personalInfo);
    }

    @Override
    public String deletePersonalInfoById(UUID id) {
        if (!personalInfoRepository.existsById(id)) {
            new NoSuchElementException("Could not delete non existing personal info! id " + id);
        }
        personalInfoRepository.deleteById(id);
        return "Personal info deleted! id " + id;
    }
}
