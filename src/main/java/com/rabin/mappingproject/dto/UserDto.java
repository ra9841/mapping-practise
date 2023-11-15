package com.rabin.mappingproject.dto;


import com.rabin.mappingproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String userName;
    private String userAddress;
    private String userPhoneNumber;
    private ProductDto products;
}
