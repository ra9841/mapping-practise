package com.rabin.mappingproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "admin_tbl")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private Long id;
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @OneToMany(mappedBy = "admins", cascade = CascadeType.ALL)
    private List<Product> products;  //where one admin can belong to a multiple product

}
