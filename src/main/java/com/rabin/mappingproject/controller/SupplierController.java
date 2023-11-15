package com.rabin.mappingproject.controller;

import com.rabin.mappingproject.dto.SupplierDto;
import com.rabin.mappingproject.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

//    @PostMapping
//    public SupplierDto registeringTheRecord(@RequestBody SupplierDto supplierDto){
//        return supplierService.savingTheRecord(supplierDto);
//    }

    @PostMapping("/register")
    public SupplierDto registeringTheRecordSingleWay(@RequestBody SupplierDto supplierDto){
        return supplierService.savintTheRecordSingleWay(supplierDto);
    }
    @GetMapping("/show")
    public List<SupplierDto> gettingAllRecords(){
        return supplierService.gettingAllRecordsInList();
    }

    //we are doing many to many mapping here
    @GetMapping("/{supplierName}/material/{materialName}")
    public SupplierDto assignSupplierToMaterial(@PathVariable String supplierName, @PathVariable String materialName) throws Exception {
        return supplierService.assignSupplierToMaterial(supplierName,materialName);
    }
    @PutMapping("/{supplierId}/material-supply/{materialId}")
    public SupplierDto assignSupplierToMaterialById(@PathVariable Long supplierId , @PathVariable Long materialId) throws Exception {
        return supplierService.assignSupplierToMaterialById(supplierId,materialId);
    }

    @GetMapping("/{supplierName}")
    public List<SupplierDto> getRecordByName(@PathVariable String supplierName) throws Exception {
        return supplierService.getRecordBySupplierName(supplierName);
    }
    @GetMapping("/id/{id}")
    public List<SupplierDto> getRecordById(@PathVariable Long id) throws Exception {
        return supplierService.getRecordBySupplierId(id);
    }

}
