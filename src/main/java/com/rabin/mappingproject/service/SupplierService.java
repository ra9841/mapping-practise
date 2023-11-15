package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.SupplierDto;

import java.util.List;
import java.util.Set;

public interface SupplierService {
//    SupplierDto savingTheRecord(SupplierDto supplierDto);


    SupplierDto savintTheRecordSingleWay(SupplierDto supplierDto);

    List<SupplierDto> gettingAllRecordsInList();

    SupplierDto assignSupplierToMaterial(String supplierName, String materialName) throws Exception;

    SupplierDto assignSupplierToMaterialById(Long supplierId, Long materialId) throws Exception;

    List<SupplierDto> getRecordBySupplierName(String supplierName) throws Exception;

    List<SupplierDto> getRecordBySupplierId(Long id) throws Exception;


}
