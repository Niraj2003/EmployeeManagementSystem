package com.employeemanagement.mapper;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.entity.Employee;


public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee savedEmployee){
        return new EmployeeDto(
            savedEmployee.getId(), 
            savedEmployee.getFirstName(), 
            savedEmployee.getLastName(), 
            savedEmployee.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(), 
            employeeDto.getFirstName(), 
            employeeDto.getLastName(), 
            employeeDto.getEmail());
    }

}
