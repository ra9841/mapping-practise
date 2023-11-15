package com.rabin.mappingproject.controller;

import com.rabin.mappingproject.dto.AdminDto;
import com.rabin.mappingproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public AdminDto registerRecord(@RequestBody AdminDto adminDto){
        return adminService.savingTheAdminInf(adminDto);
    }

    @GetMapping
    public List<AdminDto> getAllRecord(){
        return adminService.showAllRecord();
    }

}
