package com.rabin.mappingproject.controller;

import com.rabin.mappingproject.dto.MaterialDto;
import com.rabin.mappingproject.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/register")
    public MaterialDto registeringTheRecord(@RequestBody MaterialDto materialDto){
        return materialService.registerTheRecord(materialDto);
    }

    @GetMapping("/show")
    public List<MaterialDto> gettingAllRecords(){
        return materialService.gettingAllRecordsInList();
    }
}
