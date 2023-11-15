package com.rabin.mappingproject.controller;

import com.rabin.mappingproject.dto.UserDto;
import com.rabin.mappingproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto registeringRecord(@RequestBody UserDto userDto){
    return userService.saveTheRecord(userDto);
    }


}
