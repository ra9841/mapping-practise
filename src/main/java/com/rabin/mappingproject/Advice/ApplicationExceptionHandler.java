package com.rabin.mappingproject.Advice;

import com.rabin.mappingproject.exception.AdminDepartmentAlreadyPresent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(AdminDepartmentAlreadyPresent.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(AdminDepartmentAlreadyPresent ex){
        Map<String, String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",ex.getMessage());
        errorMap.put("status", HttpStatus.ALREADY_REPORTED.toString());
        return ResponseEntity.ok(errorMap);
    }
}
