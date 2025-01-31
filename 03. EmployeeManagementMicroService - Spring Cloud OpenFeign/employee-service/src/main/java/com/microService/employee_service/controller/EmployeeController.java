package com.microService.employee_service.controller;

import com.microService.employee_service.dto.ApiResponseDTO;
import com.microService.employee_service.dto.EmployeeDTO;
import com.microService.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable("id") long id){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployee(id);

        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
