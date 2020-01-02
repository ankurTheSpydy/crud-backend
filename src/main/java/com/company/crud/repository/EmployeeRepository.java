package com.company.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.crud.pojo.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	public List<Employee> findAll();
	
	public default Employee findOne(String employeeId) {
		return (Employee) findById(employeeId).orElse(null);
	}
	
}
