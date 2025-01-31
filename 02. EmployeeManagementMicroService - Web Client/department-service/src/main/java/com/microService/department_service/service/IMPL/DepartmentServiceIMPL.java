package com.microService.department_service.service.IMPL;

import com.microService.department_service.dto.DepartmentDTO;
import com.microService.department_service.entity.Department;
import com.microService.department_service.repository.DepartmentRepository;
import com.microService.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceIMPL implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );

        Department savedDepartment=departmentRepository.save(department);

        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {

        try {
            System.out.println("Department Code: " + departmentCode);

            Department department = departmentRepository.findByDepartmentCodeEquals(departmentCode);

            if (department == null) {
                throw new RuntimeException("Department not found");
            }

            DepartmentDTO departmentDTO = new DepartmentDTO(
                    department.getId(),
                    department.getDepartmentName(),
                    department.getDepartmentDescription(),
                    department.getDepartmentCode()
            );

            return departmentDTO;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
