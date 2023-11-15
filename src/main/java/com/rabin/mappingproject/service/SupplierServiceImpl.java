package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.MaterialDto;
import com.rabin.mappingproject.dto.SupplierDto;
import com.rabin.mappingproject.entity.Material;
import com.rabin.mappingproject.entity.Supplier;
import com.rabin.mappingproject.repository.MaterialRepository;
import com.rabin.mappingproject.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private MaterialRepository materialRepository;

//    @Override
//    //It's essential to use transaction management in your service layer when dealing with multiple database operations. Without proper transaction management,
//    //if an error occurs while saving one of the suppliers or materials, you may end up with an inconsistent state in the database.
//    @Transactional
//    public SupplierDto savingTheRecord(SupplierDto supplierDto) {
//        // Create a new Supplier entity
//        Supplier supplier = new Supplier();
//        supplier.setSupplierName(supplierDto.getSupplierName());
//        supplier.setAddress(supplierDto.getAddress());
//        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
//
//        // Create a set to store associated materials
//        Set<Material> materials = new HashSet<>();
//
//        // Assuming supplierDto contains a list of MaterialDto, loop through it
//        // and create Material entities and associate them with the Supplier
//        for (MaterialDto materialDto : supplierDto.getMaterials()) {
//            Material material = new Material();
//            material.setMaterialName(materialDto.getMaterialName());
//            material.setMaterialQuantity(materialDto.getMaterialQuantity());
//            material.setMaterialPrice(materialDto.getMaterialPrice());
//            material.setMaterialCost(materialDto.getMaterialPrice() * materialDto.getMaterialQuantity());
//            // Add the material to the set
//            materials.add(material);
//        }
//
//        // Set the materials in the Supplier entity
//        supplier.setMaterials(materials);
//
//        // Save the Supplier entity using your JPA repository
//        supplier = supplierRepository.save(supplier);
//
//        // Now, you can return a SupplierDto if needed
//        SupplierDto savedSupplierDto = new SupplierDto();
//        savedSupplierDto.setId(supplier.getId());
//        savedSupplierDto.setSupplierName(supplier.getSupplierName());
//        savedSupplierDto.setAddress(supplier.getAddress());
//        savedSupplierDto.setPhoneNumber(supplier.getPhoneNumber());
//
//        // You might want to set the associated MaterialDtos in the savedSupplierDto as well
//
//        return savedSupplierDto;
//    }

    @Override
    public SupplierDto savintTheRecordSingleWay(SupplierDto supplierDto) {
        Supplier supplier=new Supplier();
        BeanUtils.copyProperties(supplierDto,supplier);
        Supplier supplier1=supplierRepository.save(supplier);
        SupplierDto supplierDto1=new SupplierDto();
        BeanUtils.copyProperties(supplier1,supplierDto1);
        return supplierDto1;
    }

    @Override
    public List<SupplierDto> gettingAllRecordsInList() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(supplier -> {
            SupplierDto supplierDto = new SupplierDto();
            BeanUtils.copyProperties(supplier, supplierDto);
            return supplierDto;
        }).toList();
    }

//    @Override
//    public SupplierDto assignSupplierToMaterial(String supplierName, String materialName) {
//        Set<Material> materialSet=null;
//       Supplier supplier= supplierRepository.findBySupplierName(supplierName);
//        Material material=materialRepository.findByMaterialName(materialName);
//        materialSet=supplier.getMaterials();
//        materialSet.add(material);
//        supplier.setMaterials(materialSet);
//       Supplier supplier1= supplierRepository.save(supplier);
//       SupplierDto supplerDto=new SupplierDto();
//       BeanUtils.copyProperties(supplier1,supplerDto);
//        return supplerDto;
//    }
@Override
public SupplierDto assignSupplierToMaterial(String supplierName, String materialName) throws Exception {
    Set<Material> materialSet=null;
    Optional<Supplier> existSupplier = supplierRepository.findBySupplierName(supplierName);
    Optional<Material> existMaterial = materialRepository.findByMaterialName(materialName);

    if (existSupplier.isPresent() && existMaterial.isPresent()) {
        Supplier supplier = existSupplier.get();
        Material material = existMaterial.get();

        materialSet=supplier.getMaterials();
        materialSet.add(material);

        supplier.setMaterials(materialSet);
        Supplier supplier1 = supplierRepository.save(supplier);

        SupplierDto supplierDto = new SupplierDto();
        BeanUtils.copyProperties(supplier1, supplierDto);
        return supplierDto;
    } else {
        throw new Exception("Supplier or Material not found");
    }
}

    @Override
    public SupplierDto assignSupplierToMaterialById(Long supplierId, Long materialId) throws Exception {
        Set<Material> materialSet=null;
        Optional<Supplier> existSupplier = supplierRepository.findBySupplierId(supplierId);
        Optional<Material> existMaterial = materialRepository.findByMaterialId(materialId);

        if (existSupplier.isPresent() && existMaterial.isPresent()) {
            Supplier supplier = existSupplier.get();
            Material material = existMaterial.get();

            materialSet=supplier.getMaterials();
            materialSet.add(material);

            supplier.setMaterials(materialSet);
            Supplier supplier1 = supplierRepository.save(supplier);

            SupplierDto supplierDto = new SupplierDto();
            BeanUtils.copyProperties(supplier1, supplierDto);
            return supplierDto;
        } else {
            throw new Exception("Supplier or Material not found");
        }
    }


    @Override
    public List<SupplierDto> getRecordBySupplierName(String supplierName) throws Exception {
        Optional<Supplier> existSupplier= supplierRepository.findBySupplierName(supplierName);
        if(existSupplier.isPresent()){
         return existSupplier.stream().map(supplier -> {
              SupplierDto supplierDto = new SupplierDto();
              BeanUtils.copyProperties(supplier, supplierDto);
              return supplierDto;
          }).toList();
        }else{
            throw new Exception("name not found");
        }

    }

    @Override
    public List<SupplierDto> getRecordBySupplierId(Long id) throws Exception {
        Optional<Supplier> existSupplier = supplierRepository.findById(id);
        if (existSupplier.isPresent()) {
            return existSupplier.stream().map(supplier -> {
                SupplierDto supplierDto = new SupplierDto();
                BeanUtils.copyProperties(supplier, supplierDto);
                return supplierDto;
            }).toList();
        } else {
            throw new Exception("id not found");
        }
    }
}
