package com.spring.curd.controller;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import com.spring.curd.service.EmployeeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@ApiModel(description = "employee.class")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    private Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping("/")
    public String printHello(){
        System.out.println("Inside main");
        return "Hello";
    }

    @PostMapping("/addEmployee")
    @ApiOperation(value = "employee class",response = Employee.class)
    public Employee addEmployee(@ApiParam(value = "Employee",required = true) @RequestBody Employee employee){
        log.info("EmployeeController addEmployee() input{} ",  employee);
        employee = employeeService.saveEmployee(employee);
        log.info("EmployeeController saveEmployee() response{} ", employee);
        return employee;
    }
    /*@PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        userservice.addUser(user);
        return new ResponseEntity("User Added successfully", HttpStatus.OK);
    }*/

    @PostMapping("/addEmployees")
    @ApiOperation(value = "Add Employee", response = Employee.class)
    public List<Employee> addEmployees(@RequestBody List<Employee> employee){
        log.info("Add New Employee {} ");
        List<Employee> addEmp = employeeService.saveEmployees(employee);
        log.info("Employee added successfully! {}",employee);
        return addEmp;
    }

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

    @PutMapping("/update")
    @ApiOperation(value = "Update all Employee details",response = Employee.class)
    public Employee updateEmployee(@RequestBody Employee employee){
        log.info("Update Employee {}");
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete Employee details",response = Employee.class)
    public Employee deleteEmployee(Employee employee) {
        log.info("Delete Employee {}");
        employeeService.deleteEmployee(employee);
        return employee;
    }

    @GetMapping("/EmpByName/{name}")
    @ApiOperation(value = "Find all Employee details by Name",response = Employee.class)
    public List<Employee> findByName(@PathVariable String name) throws EmployeeServiceException {
        return employeeService.findByName(name);
    }

}


