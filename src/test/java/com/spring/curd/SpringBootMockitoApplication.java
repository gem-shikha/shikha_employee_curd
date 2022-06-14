package com.spring.curd;

import com.spring.curd.entity.Employee;
import com.spring.curd.repository.EmployeeRepository;
import com.spring.curd.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplication {
    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployeeTest(){
        Employee emp = new Employee(01L,"Pramya","Dev","E1");
        when(employeeRepository.save(emp)).thenReturn(emp);
        assertEquals(emp,employeeService.saveEmployee(emp));
    }

    @Test
    public void findAllEmployeeTest(){
        when(employeeRepository.findAll()).thenReturn(Stream.
                of( new Employee(9L,"Garima","IT","A1"), new Employee(1L,"Raman","Dev","E1"),
                        new Employee(2L,"Atmaram","Dev","E1")).collect(Collectors.toList()));
        assertEquals(3,employeeService.findAllEmployee().size());
    }
/*
    @Test
    public void findEmployeeBYId(){
        Long id = 13L;
        when(employeeRepository.findAll()).thenReturn(Stream.
                of( new Employee(13L,"Garima","IT","A1"))
                .collect(Collectors.toList()));
        assertThat(employeeService.getEmployeeById(id).equals(id));
    }*/

    @Test
    public void deleteEmployeeTest(){
        Employee emp = new Employee(26L,"Alexakl","Dev","Admin");
        employeeService.deleteEmployee(emp);
        verify(employeeRepository,times(1)).delete(emp);
    }

    @Test
    public void findByNameTest(){
        String name = "Rakhi";
        when(employeeRepository.findByName(name)).thenReturn(Stream.of(new Employee(13L,"Rakhi","Admin","A1"))
                .collect(Collectors.toList()));
        assertEquals(1,employeeService.findByName(name).size());
    }
}
