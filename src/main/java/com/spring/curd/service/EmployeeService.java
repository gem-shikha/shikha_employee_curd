package com.spring.curd.service;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> saveEmployees(List<Employee> employees);

    List<Employee> findAllEmployee();

    Employee getEmployeeById(Long empId) throws EmployeeServiceException;
    Employee updateEmployee(Employee employee);
    void deleteById(Long id);
    List<Employee> findByName(String name) throws EmployeeServiceException;
}
