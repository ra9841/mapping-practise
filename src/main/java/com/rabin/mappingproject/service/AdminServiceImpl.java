package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.ProductDto;
import com.rabin.mappingproject.entity.Product;
import com.rabin.mappingproject.entity.User;
import com.rabin.mappingproject.exception.AdminDepartmentAlreadyPresent;
import com.rabin.mappingproject.dto.AdminDto;
import com.rabin.mappingproject.entity.Admin;
import com.rabin.mappingproject.repository.AdminRepository;
import com.rabin.mappingproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;



    @Override
    public AdminDto savingTheAdminInf(AdminDto adminDto) {
        // Check if the department already exists
        Optional<Admin> existAdmin = adminRepository.findByDepartmentName(adminDto.getDepartmentName());
        if (existAdmin.isPresent() && existAdmin.get().getDepartmentName().equalsIgnoreCase(existAdmin.get().getDepartmentName())) {
            log.error("Department name is already present: {}", existAdmin.get());
            throw new AdminDepartmentAlreadyPresent("Department is already present in the database");
        }
        // Create a new Admin entity and set the department name
        Admin admin = new Admin();
        admin.setDepartmentName(adminDto.getDepartmentName());
        log.info("Record in admins department name {}", adminDto.getDepartmentName());


        // Initialize a list to store Product entities
        List<Product> products = new ArrayList<>();

        // Loop through the ProductDto list and create Product entities
        List<ProductDto> productDtos = adminDto.getProducts();
        for (ProductDto productDto : productDtos) {
            Product product = new Product();
            product.setProductName(productDto.getProductName());
            product.setProductQuantity(productDto.getProductQuantity());
            product.setProductPrice(productDto.getProductPrice());
            product.setProductCost(productDto.getProductQuantity() * productDto.getProductPrice());
            product.setAdmins(admin);   // Associate the Product entity with the Admin

            products.add(product);
        }

        log.info("Data in products {}", products);
        // Set the list of products for the Admin entity
        admin.setProducts(products);


        // Save the Admin entity
        Admin savedAdmin = adminRepository.save(admin);

        // Create and return an AdminDto for the saved admin
        AdminDto adminDto1 = new AdminDto();
        BeanUtils.copyProperties(savedAdmin, adminDto1);

        List<ProductDto> productDtos1 = savedAdmin.getProducts().stream().map(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            return productDto;
        }).toList();

        adminDto1.setProducts(productDtos1);

        log.info("Record from dataBase & transferring to User {}", adminDto1);
        return adminDto1;
    }


    @Override
    public List<AdminDto> showAllRecord() {
        return adminRepository.findAll().stream().map(admin -> {
            AdminDto adminDto = new AdminDto();
            BeanUtils.copyProperties(admin, adminDto);
            log.info("Record which will came from  database {}", adminDto);
            return adminDto;
        }).toList();
    }




}
