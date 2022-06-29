/*
package com.spring.curd.controller;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import com.spring.curd.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
public class EmployeeNewController {

    @Autowired
    EmployeeService employeeService;

    */
/**
     * Create new employee
     *
     * @param employee
     * @return ResponseEntity
     *//*


    @PostMapping("/employee")
    @ApiOperation(value = "Add employee", response = Employee.class)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        log.info("EmployeeController addEmployee() input {} ");
        ResponseEntity<Employee> employeeDetails = employeeService.saveEmployee(employee);
        log.info("EmployeeController saveEmployee() response {} ", employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

*/
/**
     * Get all the employees
     *
     * @return ResponseEntity
     *//*


    @GetMapping("/employee")
    @ApiOperation(value = "Fetch all employee details", response = Employee.class)
    public ResponseEntity<List<Employee>> getEmpDetails() {
        log.info("EmployeeController addEmployee() input {} ");
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.findAllEmployee();
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

*/
/**
     * Get the employee by id
     *
     * @param id
     * @return ResponseEntity
     *//*


        @GetMapping("/employee/{id}")
        @ApiOperation(value = "Fetch employee details by id", response = Employee.class)
        public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws EmployeeServiceException {
            log.info("EmployeeController getEmployee Details by employee id {} : ");
            Employee emp = employeeService.getEmployeeById(id);
            try {
                if (emp != null) {
                    return new ResponseEntity<>(emp, HttpStatus.OK);
                }
                return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                log.error("Employee id doesn't exist!");
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

*/
/**
     * Update Employee record by using it's id
     *
     * @param id
     * @param employee
     * @return
     *//*

        @PutMapping("/update/{id}")
        @ApiOperation(value = "Update employee by it's id", response = Employee.class)
        public ResponseEntity<Employee> updateEmpDetails(@PathVariable("id") Long id, @RequestBody Employee employee) throws EmployeeServiceException {
            Employee emp = employeeService.getEmployeeById(id);
                if (emp != null) {
                    emp.setName(employee.getName());
                    emp.setDepartment(employee.getDepartment());
                    emp.setGrade(employee.getGrade());
                    employeeService.saveEmployee(emp);
                }
            return new ResponseEntity<>( emp, HttpStatus.NOT_FOUND);
        }

*/
/**
     * Delete Employee record by using it's id
     *
     * @param id
     * @return
     *//*


        @DeleteMapping("employee/{id}")
        @ApiOperation(value = "Delete employee by id", response = Employee.class)
        public ResponseEntity<Employee> deleteEmpById(@PathVariable("id") Long id) throws EmployeeServiceException {
            Employee emp = emp = employeeService.getEmployeeById(id);
            try {
                if (emp != null) {
                    employeeService.deleteById(id);
                    return new ResponseEntity<>(emp, HttpStatus.OK);
                }
                return new ResponseEntity<>(emp,HttpStatus.NOT_FOUND);
            }
            catch (Exception e){
                log.error("Exception in deleteEmpById() ");
                return new ResponseEntity<>(emp,HttpStatus.INTERNAL_SERVER_ERROR);
             }
        }
*/
/**
     * Delete all employees
     *
     * @return ResponseEntity
     *//*
*/
/*
*//*


        @DeleteMapping("/employee")
        @ApiOperation(value = "Delete all employee", response = Employee.class)
        public ResponseEntity<HttpStatus> deleteAllEmployees(){
            employeeService.delete();
            return new ResponseEntity<>(HttpStatus.OK);
        }
}

*/
