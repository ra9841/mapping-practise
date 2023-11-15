package com.rabin.mappingproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDto {
    private Long supplierId;
    private String supplierName;
    private String address;
    private String phoneNumber;
    private Set<MaterialDto> materials;
}
