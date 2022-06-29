package com.spring.curd.service;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import com.spring.curd.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Slf4j
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Employee saveEmployee(Employee employee) {
        Employee saveEmp = null;
        try {
            saveEmp = empRepo.save(employee);
        }
        catch (Exception e){
           log.error("Exception in saveEmployee() {} :",e.getMessage());
        }
        return saveEmp;
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return empRepo.saveAll(employees);
    }

    public List<Employee> findAllEmployee() {
        List<Employee> emps = empRepo.findAll();
        System.out.println("Getting data from Db :"+ emps);
        return emps;
    }
    public Employee getEmployeeById(Long empId) throws EmployeeServiceException {
        Employee getEmp = null;
        Long id = 0L;
        try {
            if(empId != null){
            getEmp = empRepo.findById(empId).orElse(null);
            id = getEmp.getEmpId();
            }
        }
        catch (Exception e){
            log.error("Exception in getEmployeeById() : {}", e.getMessage());
            throw new EmployeeServiceException("Employee Id doesn't exist!"+ id);
        }
        return getEmp;
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = empRepo.findById(employee.getEmpId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setGrade(employee.getGrade());
        return empRepo.save(existingEmployee);
    }


    public void deleteById(Long id){
        empRepo.deleteById(id);
    }

    @Override
    public List<Employee> findByName(String name) throws EmployeeServiceException {
        List<Employee> employee = null;
        try {
            if (employee != null) {
                employee = empRepo.findByName(name);
            }
        }
        catch (Exception e){
            log.error("Exception in findByName() : {}", e.getMessage());
            throw new EmployeeServiceException("Employee name doesn't exist!"+ name);
        }
        return employee;
    }
}
