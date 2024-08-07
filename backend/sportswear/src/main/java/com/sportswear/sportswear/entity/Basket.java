package com.sportswear.sportswear.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REFRESH;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade = {MERGE, REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "items", referencedColumnName = "id")
    private Item itemId;

    @Column(name = "quantity")
    private Integer quantity;
}