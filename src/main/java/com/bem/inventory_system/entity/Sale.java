package com.bem.inventory_system.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantitySold;

    @Column(nullable = false)
    private double salePrice;

    @Column(updatable = false)
    private LocalDateTime soldAt;

    @PrePersist
    protected void onSale() {
        soldAt = LocalDateTime.now();
    }
    
}
