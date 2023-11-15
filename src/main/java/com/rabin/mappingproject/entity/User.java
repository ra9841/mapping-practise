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
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" , nullable = false)
    private Long id;
    @Column(name = "user_name" , nullable = false)
    private String userName;
    @Column(name = "user_address" , nullable = false)
    private String userAddress;
    @Column(name = "user_phNumber" , nullable = false)
    private String userPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product products;
}
