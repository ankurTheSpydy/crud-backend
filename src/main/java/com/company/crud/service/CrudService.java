package com.company.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.crud.dao.CrudOperationImpl;
import com.company.crud.pojo.Employee;

@Component
public class CrudService {

	@Autowired
	CrudOperationImpl coi;
	
	public List<Employee> getAllEmployees() {
		return coi.getAll();
	}
	
	public Employee getEmployee(String employeeId) {
		return coi.getEmployeeById(employeeId);
	}
	
	public String saveEmployee(Employee e) {
		return coi.saveEmployee(e);
	}
	
	public String deleteEmployeeById(String employeeId) {
		return coi.deleteEmployeeById(employeeId);
	}
	
	public String updateEmployee(Employee e, String employeeId) {
		return coi.updateEmployee(e, employeeId);
	}
}
