package com.microService.department_service.controller;

import com.microService.department_service.dto.DepartmentDTO;
import com.microService.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO saveDepartmentDTO = departmentService.saveDepartment(departmentDTO);

        return new ResponseEntity<>(saveDepartmentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("code") String departmentCode){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
