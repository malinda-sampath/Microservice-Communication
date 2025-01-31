package com.microService.department_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DepartmentDTO {
        private Long id;
        private String departmentName;
        private String departmentDescription;
        private String departmentCode;
}
