package com.microService.employee_service.service;

import com.microService.employee_service.dto.ApiResponseDTO;
import com.microService.employee_service.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployee(long id);
}
