package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.MaterialDto;
import com.rabin.mappingproject.entity.Material;
import com.rabin.mappingproject.repository.MaterialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public MaterialDto registerTheRecord(MaterialDto materialDto) {
        Material material=new Material();
        BeanUtils.copyProperties(materialDto,material);
        material.setMaterialCost(materialDto.getMaterialPrice() * materialDto.getMaterialQuantity());
        Material material1=materialRepository.save(material);
        MaterialDto materialDto1=new MaterialDto();
        BeanUtils.copyProperties(material1,materialDto1);
        return materialDto1;
    }

    @Override
    public List<MaterialDto> gettingAllRecordsInList() {
      return  materialRepository.findAll().stream().map(material -> {
            MaterialDto materialDto=new MaterialDto();
            BeanUtils.copyProperties(material,materialDto);
            return materialDto;
        }).toList();
    }
}
