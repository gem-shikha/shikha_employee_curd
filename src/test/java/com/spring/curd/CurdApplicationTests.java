package com.spring.curd;

import com.spring.curd.entity.Employee;
import com.spring.curd.repository.EmployeeRepository;
import com.spring.curd.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class CurdApplicationTests {
    @Autowired
	private EmployeeRepository repository;

	@Autowired
	private EmployeeService service;

	@Test
	@Order(1)
	public void testSaveEmployee () {
	Employee e = new Employee();
	e.setEmpId(9L);
	e.setName("Alexakl");
	e.setDepartment("Dev");
	e.setGrade("A1");
	Employee create = repository.save(e);
	assertNotNull(create);
	assertThat(e);
    }

	@Test
	@Order(value = 2)
	public void testGetListOfEmployee () {
		List<Employee> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
       	}

	@Test
	@Order(3)
	public void testGetEmployeeByID(){
		repository.findById(15L);
		assertThat(repository.findById(15L));
	}

	 @Test
	 @Order(4)
	 public void testUpdate(){
		Employee emp=repository.findById(24L).get();
		emp.setName("Ram");
		emp.setDepartment("IT Admin");
		Employee update = repository.save(emp);
		assertThat(update.getName()).isEqualTo("Ram");
		assertNotNull("IT Admin", repository.findById(24L).get().getDepartment());
	 }

	@Test
	@Order(5)
	public void testFindByName(){
		String name = "Rakhi";
		List<Employee> emp = repository.findByName(name);
		assertThat(emp.contains(name));
		assertNotNull(emp);
	}

	@Test
	@Order(6)
	public void testDelete(){
		repository.deleteById(21L);
	    assertThat(repository.existsById(15L)).isFalse();
	}

}