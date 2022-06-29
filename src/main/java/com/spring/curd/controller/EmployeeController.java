package com.spring.curd.controller;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import com.spring.curd.service.EmployeeService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@ApiOperation(value = "Employee CURD Operation USing SpringBoot and JPA")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    private Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employee")
    @ApiOperation(value = "Get all Employee details", response = Employee.class)
    public List<Employee> findAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployee();
        log.info("Employee Controller findAllEmployee() ", employees);
        return employees;
    }

    @GetMapping("/employee/{empId}")
    @ApiOperation(value = "Get Employee details by Id",response = Employee.class)
    public Employee findEmployeeBYId(@PathVariable Long empId) throws EmployeeServiceException {
        log.info("Get Employee details {}");
        Employee empDetails = employeeService.getEmployeeById(empId);
        log.info("Get Employee details {}",empDetails);
        return empDetails;
    }

    @PostMapping("/employee")
    @ApiOperation(value = "Add new employee",response = Employee.class)
    public Employee addEmployee(@ApiParam(value = "Employee",required = true) @RequestBody Employee employee){
        log.info("EmployeeController addEmployee() input{} ",  employee);
        employee = employeeService.saveEmployee(employee);
        log.info("EmployeeController saveEmployee() response{} ", employee);
        return employee;
    }

    /*@PostMapping("/user")
    @ApiOperation(value = "Add Employee", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
    public ResponseEntity addUser(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity("User Added successfully", HttpStatus.OK);
    }
*/

    @PostMapping("/employees")
    @ApiOperation(value = "Add Employees ", response = Employee.class)
    public List<Employee> addEmployees(@RequestBody List<Employee> employee){
        log.info("Add New Employee {} ");
        List<Employee> addEmp = employeeService.saveEmployees(employee);
        log.info("Employee added successfully! {}",employee);
        return addEmp;
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update all Employee details",response = Employee.class)
    public Employee updateEmployee(@RequestBody Employee employee){
        log.info("Update Employee {}");
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Employee details",response = Employee.class)
    public void deleteEmployee(@PathVariable Long id) {
        log.info("Delete Employee {}");
        employeeService.deleteById(id);
    }

    @GetMapping("/employee/{name}")
    @ApiOperation(value = "Find all Employee details by Name",response = Employee.class)
    public List<Employee> findByName(@PathVariable String name) throws EmployeeServiceException {
        return employeeService.findByName(name);
    }

}

