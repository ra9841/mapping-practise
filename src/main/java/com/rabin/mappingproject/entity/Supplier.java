package com.rabin.mappingproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "suppler_tbl")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;
    @Column(name = "supplier_address", nullable = false)
    private String address;
    @Column(name = "supplier_phNumber", nullable = false)
    private String phoneNumber;

    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "supplier_material",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private Set<Material> materials;  //where multiple supplier can belong to a single material
}
