package com.spring.curd;

import com.spring.curd.entity.Employee;
import com.spring.curd.exception.EmployeeServiceException;
import com.spring.curd.repository.EmployeeRepository;
import com.spring.curd.service.EmployeeServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplication {
    @InjectMocks
    private EmployeeServiceImp employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployeeTest() {
        Employee emp = new Employee(1L, "Pramya", "Dev", "E1");
        when(employeeRepository.save(emp)).thenReturn(emp);
        assertEquals(emp, employeeService.saveEmployee(emp));
        assertNotNull(emp.getGrade());
        assertNotNull(emp.getDepartment());
        assertNotNull(emp.getGrade());
        assertThat(emp.getEmpId().equals(1L));
        verify(employeeRepository, times(1)).save(emp);
    }

    @Test
    public void findAllEmployeeTest(){
        when(employeeRepository.findAll()).thenReturn(Stream.
                of( new Employee(9L,"Garima","IT","A1"), new Employee(1L,"Raman","Dev","E1"),
                        new Employee(2L,"Atmaram","Dev","E1")).collect(Collectors.toList()));
        assertEquals(3,employeeService.findAllEmployee().size());
    }

    @Test
    public void saveEmployeesTest(){
        Employee e1 = new Employee(9L,"Garima","IT","A1");
        Employee e2 = new Employee(2L,"Atmaram","Dev","E1");
        Employee e3 = new Employee(1L,"Raman","Dev","E1");

        List<Employee> list = Arrays.asList(e1,e2,e3);

        when(employeeRepository.saveAll(list)).thenReturn(list);
        assertEquals(3,employeeService.saveEmployees(list).size());
    }

    @Test
    public void empByNameTest() throws EmployeeServiceException {
        String name = "Garima";
        when(employeeRepository.findByName(name))
                .thenReturn(Stream.
                of( new Employee(7L,"Garima","IT","A1")).collect(Collectors.toList()));
        assertEquals(1,employeeService.findByName(name).size());
    }

    @Test
    public void deleteUserTest(){
        Employee emp = new Employee(111L,"Priyanka","Admin","IT1");
        employeeService.deleteById(111L);
        verify(employeeRepository,times(1)).deleteById(111L);
    }


}
