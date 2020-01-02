package com.company.crud.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.crud.pojo.Employee;


@Service
public interface CrudOperation {
	
	public List<Employee> getAll();
	
	public Employee getEmployeeById(String employeeId);
	
	public String saveEmployee(Employee emp);
	
	public String deleteEmployeeById(String employeeId);
	
	public String updateEmployee(Employee emp, String employeeId);

}
