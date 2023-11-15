package com.rabin.mappingproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "material_tbl")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialId;
    @Column(name = "material_name" ,nullable = false)
    private String materialName;
    @Column(name = "material_quantity" , nullable = false)
    private Long materialQuantity;
    @Column(name = "material_price" , nullable = false)
    private Long materialPrice;
    @Column(name = "material_cost" , nullable = false)
    private Long materialCost;

    @ManyToMany(mappedBy = "materials")
    @JsonProperty
    private Set<Supplier> suppliers; //where multiple material can belong to a multiple supplier
}
