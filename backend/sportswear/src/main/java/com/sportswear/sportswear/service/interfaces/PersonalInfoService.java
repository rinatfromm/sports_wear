package com.sportswear.sportswear.service.interfaces;

import com.sportswear.sportswear.dto.PersonalInfoDTO;

import java.util.UUID;

public interface PersonalInfoService {
    PersonalInfoDTO createPersonalInfo(PersonalInfoDTO personalInfoDTO);
    PersonalInfoDTO getPersonalInfoById(UUID id);
    PersonalInfoDTO updatePersonalInfoById(PersonalInfoDTO personalInfoDTO);
}
