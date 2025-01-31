package com.microService.employee_service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
}
