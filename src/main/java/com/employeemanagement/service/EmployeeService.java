package com.employeemanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employeemanagement.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    ResponseEntity<EmployeeDto> getEmployeeById(Long id);
}
