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
@Table(name = "delivery_addresses")
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = {MERGE, REFRESH})
    @JoinColumn(name = "clients_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @Column(name = "country", length = 32, nullable = false)
    private String country;

    @Column(name = "city", length = 32, nullable = false)
    private String city;

    @Column(name = "street", length = 32, nullable = false)
    private String street;

    @Column(name = "house_number", length = 32, nullable = false)
    private String houseNumber;

    @Column(name = "floor", length = 32, nullable = false)
    private String floor;

    @Column(name = "apartment", length = 32, nullable = false)
    private Integer apartment;

    @Column(name = "active")
    private Boolean active;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}
