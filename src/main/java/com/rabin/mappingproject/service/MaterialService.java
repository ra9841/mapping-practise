package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    MaterialDto registerTheRecord(MaterialDto materialDto);

    List<MaterialDto> gettingAllRecordsInList();
}
