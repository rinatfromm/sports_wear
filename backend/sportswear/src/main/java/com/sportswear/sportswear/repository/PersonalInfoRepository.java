package com.sportswear.sportswear.repository;

import com.sportswear.sportswear.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, UUID> {
    PersonalInfo findAllById(UUID uuid);
}