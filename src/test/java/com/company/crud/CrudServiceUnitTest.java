package com.company.crud;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.crud.dao.CrudOperationImpl;
import com.company.crud.pojo.Employee;
import com.company.crud.service.CrudService;

@RunWith(SpringRunner.class)
public class CrudServiceUnitTest {

	@TestConfiguration
	static class CrudServiceUnitTestContextConfiguration {
		@Bean
		public CrudService crudService() {
			return new CrudService();
		}
	}
	
	@Autowired
	private CrudService cs;
	
	@MockBean
	private CrudOperationImpl coi;
	
	@Before
	public void setUp() {
		Employee employeeOne = new Employee();
		employeeOne.setEmployeeId("T007");
		employeeOne.setEmployeeName("Test User_7");
		employeeOne.setDepartment("Dept 3");
		employeeOne.setJobGrade("C");
		employeeOne.setManagerName("M_Test User_4");
		employeeOne.setEmploymentType("Contract");
		
		Employee employeeTwo = new Employee();
		employeeTwo.setEmployeeId("T008");
		employeeTwo.setEmployeeName("Test User_8");
		employeeTwo.setDepartment("Dept 3");
		employeeTwo.setJobGrade("A");
		employeeTwo.setManagerName("M_Test User_4");
		employeeTwo.setEmploymentType("Permanent");
		
		List<Employee> employees = new ArrayList<>();
		employees.add(0, employeeOne);
		employees.add(1, employeeTwo);
		
		when(coi.getAll()).thenReturn(employees);
		when(coi.getEmployeeById("T007")).thenReturn(employeeOne);
		when(coi.saveEmployee(employeeTwo)).thenReturn(employeeTwo.getEmployeeId() + " details are saved in the DB.");
		when(coi.deleteEmployeeById("T007")).thenReturn("Delete successful for employee Id " + employeeOne.getEmployeeId());
		when(coi.updateEmployee(employeeTwo, "T008")).thenReturn(employeeTwo.getEmployeeId() + " details are updated in the DB.");
	}
	
	@Test
	public void whenAllEmployeesFetched() {
		assertEquals(cs.getAllEmployees().size(), 2);
	}
	
	@Test
	public void whenEmployeeByIdIsFetched() {
		assertEquals(cs.getEmployee("T007").getEmployeeName(), "Test User_7");
	}
	
	@Test
	public void whenDeleteEmployeeById() {
		assertEquals(cs.deleteEmployeeById("T007"), "Delete successful for employee Id T007");
	}
}
