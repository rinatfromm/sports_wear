package com.sportswear.sportswear.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH, PERSIST})
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonBackReference
    private Order order;

    @ManyToOne(cascade = {MERGE, REFRESH, DETACH, PERSIST})
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @JsonBackReference
    private Item item;
}
