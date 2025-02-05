package com.microService.employee_service.service.impl;

import com.microService.employee_service.dto.ApiResponseDTO;
import com.microService.employee_service.dto.DepartmentDTO;
import com.microService.employee_service.dto.EmployeeDTO;
import com.microService.employee_service.entity.Employee;
import com.microService.employee_service.repository.EmployeeRepository;
import com.microService.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WebClient webClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDTO;
    }

    @Override
    public ApiResponseDTO getEmployee(long id) {
        Employee employee = employeeRepository.findById(id).get();

        DepartmentDTO departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/get/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();//Make the request synchronous

        //https://www.javaguides.net/2022/10/spring-boot-microservices-communication-using-webclient.html
        //example of using webclient to make a synchronous request

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(employeeDTO, departmentDTO);
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }
}
