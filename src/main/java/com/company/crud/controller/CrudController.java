package com.company.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.crud.pojo.Employee;
import com.company.crud.service.CrudService;

@RestController
public class CrudController {

	Logger logger = LoggerFactory.getLogger(CrudController.class);

	@Autowired
	CrudService cs;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public List<Employee> getEmployeesList() {
		List<Employee> employees = new ArrayList<>();
		try {
			employees = cs.getAllEmployees();
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return employees;
	}
	
	@RequestMapping(value = "/getEmployeeById/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable String employeeId) {
		Employee employee = new Employee();
		try {
			employee = cs.getEmployee(employeeId.toUpperCase());
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return employee;
	}
	
	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		String message = employee.getEmployeeId() + " save details failed.";
		try {
			message = cs.saveEmployee(employee);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE)
	public String deleteEmployeeById(@PathVariable String employeeId) {
		String message = "Delete failed for employee Id " + employeeId;
		try {
			message = cs.deleteEmployeeById(employeeId.toUpperCase());
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}
	
	@RequestMapping(value = "/updateEmployeeDetails/{employeeId}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
		String message = "Update failed for employee Id " + employeeId;
		try {
			message = cs.updateEmployee(employee, employeeId);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}

}
