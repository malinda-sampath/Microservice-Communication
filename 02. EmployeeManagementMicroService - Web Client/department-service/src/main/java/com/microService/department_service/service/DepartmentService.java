package com.microService.department_service.service;

import com.microService.department_service.dto.DepartmentDTO;

public interface DepartmentService {
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    public DepartmentDTO getDepartmentByCode(String departmentCode);
}
