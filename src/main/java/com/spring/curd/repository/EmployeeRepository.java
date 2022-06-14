package com.spring.curd.repository;

import com.spring.curd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

     @Query(value = "Select * from Employee_Table where name = ?1", nativeQuery = true)
     List<Employee> findByName(String name);
}
