package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.ProductDto;
import com.rabin.mappingproject.dto.UserDto;
import com.rabin.mappingproject.entity.Product;
import com.rabin.mappingproject.entity.User;
import com.rabin.mappingproject.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveTheRecord(UserDto userDto) {
        User user=new User();
        user.setUserName(userDto.getUserName());
        user.setUserAddress(userDto.getUserAddress());
        user.setUserPhoneNumber(userDto.getUserPhoneNumber());

        // Create a new Product and set its properties
        Product product=new Product();
        product.setProductName(userDto.getProducts().getProductName());
        product.setProductQuantity(userDto.getProducts().getProductQuantity());
        product.setProductPrice(userDto.getProducts().getProductPrice());
        product.setProductCost(userDto.getProducts().getProductQuantity() * userDto.getProducts().getProductPrice());

        // Associate the product with the user
        user.setProducts(product);

        // Save the user entity with the associated product
        User user1=userRepository.save(user);

        // Create a new UserDto and copy user1's properties to it
        UserDto userDto1=new UserDto();
        BeanUtils.copyProperties(user1,userDto1);

        return userDto1;
    }
}
