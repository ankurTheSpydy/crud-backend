package com.company.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.crud.controller.CrudController;
import com.company.crud.pojo.Employee;
import com.company.crud.repository.EmployeeRepository;

@Component
public class CrudOperationImpl implements CrudOperation {

	Logger logger = LoggerFactory.getLogger(CrudController.class);
	
	@Autowired
	EmployeeRepository er;
	
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<>();
		try {
			employees = er.findAll();
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		Employee employee = new Employee();
		try {
			employee = er.findOne(employeeId);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return employee;
	}

	@Override
	public String saveEmployee(Employee emp) {
		String message = emp.getEmployeeId() + " save details failed.";
		try {
			er.save(emp);
			message = emp.getEmployeeId() + " details are saved in the DB.";
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}

	@Override
	public String deleteEmployeeById(String employeeId) {
		String message = "Delete failed for employee Id " + employeeId;
		try {
			er.deleteById(employeeId);
			message = "Delete successful for employee Id " + employeeId;
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}

	@Override
	public String updateEmployee(Employee emp, String employeeId) {
		String message = "Update failed for employee Id " + employeeId;
		try {
			er.save(emp);
			message = emp.getEmployeeId() + " details are updated in the DB.";
		} catch (Exception ex) {
			logger.error(ex.toString());
		}
		return message;
	}
}
