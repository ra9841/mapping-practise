package com.rabin.mappingproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_quantity", nullable = false)
    private Long productQuantity;
    @Column(name = "product_price", nullable = false)
    private Long productPrice;
    @Column(name = "product_cost")
    private Long productCost;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admins; //where multiple product can belong to a single admin
}
