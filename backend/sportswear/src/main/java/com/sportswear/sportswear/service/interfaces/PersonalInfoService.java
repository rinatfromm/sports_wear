package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.PersonalInfoDTO;

import java.util.UUID;

public interface PersonalInfoService {
    void createPersonalInfo(PersonalInfoDTO personalInfoDTO);
    PersonalInfoDTO getPersonalInfoById(UUID id);
    void updatePersonalInfoById(PersonalInfoDTO personalInfoDTO);
}
