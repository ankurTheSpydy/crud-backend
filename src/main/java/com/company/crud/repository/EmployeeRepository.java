package com.company.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.crud.pojo.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	public default Employee findOne(String employeeId) {
		return (Employee) findById(employeeId).orElse(null);
	}
	
}
