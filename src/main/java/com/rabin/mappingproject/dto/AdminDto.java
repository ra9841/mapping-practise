package com.rabin.mappingproject.dto;


import com.rabin.mappingproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDto {
    private Long id;
    private String departmentName;
    private List<ProductDto> products;
    private UserDto user;
}
