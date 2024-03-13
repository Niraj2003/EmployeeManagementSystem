package com.employeemanagement.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.mapper.EmployeeMapper;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        @SuppressWarnings("null")
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
		List<Employee> employees = employeeRepository.findAll();
		employees.stream().forEach(employee -> {
			EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
			employeeDtos.add(employeeDto);
		});
		return employeeDtos;
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
        @SuppressWarnings("null")
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeDto emp = EmployeeMapper.mapToEmployeeDto(employee);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
