package com.microService.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApiResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}
