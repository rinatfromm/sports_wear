package com.sportswear.sportswear.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "id")
    private UUID id;

    @Column(name = "item_id")
    private UUID itemId;
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST} )
//    @JoinColumn(name = "items_id", referencedColumnName = "id")
//    @JsonBackReference
//    private Item item;
}