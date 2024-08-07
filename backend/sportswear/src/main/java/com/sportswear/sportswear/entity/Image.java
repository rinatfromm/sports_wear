package com.sportswear.sportswear.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_id")
//    private Item itemId;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private UUID itemId;
}