package com.employeemanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.service.EmployeeService;

import lombok.AllArgsConstructor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDto>>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }
    

    @GetMapping("/")
    public String home() {
        return "HomePage";
    }
    

}
