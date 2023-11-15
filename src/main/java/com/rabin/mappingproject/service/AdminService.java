package com.rabin.mappingproject.service;

import com.rabin.mappingproject.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto savingTheAdminInf(AdminDto adminDto);

    List<AdminDto> showAllRecord();
}
