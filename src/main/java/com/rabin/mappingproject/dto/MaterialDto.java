package com.rabin.mappingproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MaterialDto {
    private Long materialId;
    private String materialName;
    private Long materialQuantity;
    private Long materialPrice;
}
