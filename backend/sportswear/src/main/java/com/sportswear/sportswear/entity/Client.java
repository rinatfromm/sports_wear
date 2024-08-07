package com.sportswear.sportswear.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REFRESH;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade = {MERGE, REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "personal_infos", referencedColumnName = "id")
    private PersonalInfo personalInfo;

    @OneToOne(cascade = {MERGE, REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "baskets", referencedColumnName = "id")
    private Basket basket;

    @Column(name = "active")
    private Boolean active;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}