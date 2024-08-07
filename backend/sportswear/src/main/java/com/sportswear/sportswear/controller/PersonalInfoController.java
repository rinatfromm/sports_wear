package com.sportswear.sportswear.controller;

import com.sportswear.sportswear.dto.PersonalInfoDTO;
import com.sportswear.sportswear.service.interfaces.PersonalInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/personal-info")
public class PersonalInfoController {
    private final PersonalInfoService personalInfoService;

    @PostMapping(value = "/create")
    public ResponseEntity<PersonalInfoDTO> createPersonalInfo(@RequestBody @Valid PersonalInfoDTO personalInfoDTO) {
        return ResponseEntity.ok().body(personalInfoService.createPersonalInfo(personalInfoDTO));
    }

    @GetMapping(value = "/get/by/id/{id}")
    public ResponseEntity<PersonalInfoDTO> getPersonalInfoById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(personalInfoService.getPersonalInfoById(id));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<PersonalInfoDTO> updatePersonalInfoById(@RequestBody @Valid PersonalInfoDTO personalInfoDTO) {
        return ResponseEntity.ok().body(personalInfoService.updatePersonalInfoById(personalInfoDTO));
    }
}
