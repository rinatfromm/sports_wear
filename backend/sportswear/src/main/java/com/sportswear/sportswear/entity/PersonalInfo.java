package com.sportswear.sportswear.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "personal_infos")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;

    @Column(name = "middle_name", length = 32, nullable = false)
    private String middleName;

    @Column(name = "phone", length = 32, nullable = false)
    private String phone;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}
