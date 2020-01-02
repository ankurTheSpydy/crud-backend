package com.company.crud;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.crud.pojo.Employee;
import com.company.crud.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryUnitTest {
	
	@Autowired
	private EmployeeRepository er;
	
	@Test
	public void whenFindAllEmployees_thenReturnAllTheRows() {
		List<Employee> employees = new ArrayList<>();
		employees = er.findAll();
		assertEquals(employees.size(), 6);
		assertEquals(employees.get(0).getEmployeeId(), "T001");
	}
	
	@Test
	public void whenFindByEmployeeId_thenReturnEmployee() {
		Employee employee = new Employee();
		employee = er.findOne("T002");
		assertEquals(employee.getEmployeeName(), "Test User_2");
		assertEquals(employee.getEmploymentType(), "Permanent");
	}
	
	@Test
	public void whenSaveEmployee_thenReturnSuccessMessage() {
		Employee employee = new Employee();
		employee.setEmployeeId("T007");
		employee.setEmployeeName("Test User_7");
		employee.setDepartment("Dept 3");
		employee.setJobGrade("C");
		employee.setManagerName("M_Test User_4");
		employee.setEmploymentType("Contract");
		er.save(employee);
		List<Employee> employees = new ArrayList<>();
		employees = er.findAll();
		assertEquals(employees.size(), 7);
		assertEquals(employees.get(6).getEmployeeId(), "T007");
	}
	
	@Test
	public void whenDeleteEmployeeById_thenEmployeeShouldBeDeleted() {
		er.deleteById("T001");
		List<Employee> employees = new ArrayList<>();
		employees = er.findAll();
		assertEquals(employees.size(), 5);
		assertEquals(employees.get(0).getEmployeeId(), "T002");
	}
	
	@Test
	public void whenUpdateEmployee_thenDetailsShouldBeUpdated() {
		List<Employee> employees = new ArrayList<>();
		employees = er.findAll();
		assertEquals(employees.size(), 6);
		assertEquals(employees.get(0).getDepartment(), "Dept 1");
		Employee employee = new Employee();
		employee.setEmployeeId("T001");
		employee.setEmployeeName("Test User_1");
		employee.setDepartment("Dept 2");
		employee.setJobGrade("D");
		employee.setManagerName("M_Test User_2");
		employee.setEmploymentType("Permanent");
		er.save(employee);
		employees = er.findAll();
		assertEquals(employees.size(), 6);
		assertEquals(employees.get(0).getDepartment(), "Dept 2");
	}
}
