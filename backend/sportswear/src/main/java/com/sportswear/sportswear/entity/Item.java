package com.sportswear.sportswear.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "category", length = 32, nullable = false)
    private String category;

    @Column(name = "size", length = 32, nullable = false)
    private String size;

    @Column(name = "price", precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "weight", precision = 3, scale = 2, nullable = false)
    private BigDecimal weight;

    @Column(name = "color", length = 32, nullable = false)
    private String color;

    @Column(name = "in_stock", length = 32, nullable = false)
    private Integer inStock;

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "updated")
    private  LocalDateTime updated;
}
