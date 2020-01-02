package com.company.crud.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMPLOYEES")
@Data
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name="EMPLOYEE_NAME", length=250, nullable=false, unique=false)
	private String employeeName;
	
	@Column(name="DEPARTMENT", length=250, nullable=false, unique=false)
	private String department;
	
	@Column(name="JOB_GRADE", length=250, nullable=false, unique=false)
	private String jobGrade;
	
	@Column(name="MANAGER_NAME", length=250, nullable=false, unique=false)
	private String managerName;
	
	@Column(name="EMPLOYMENT_TYPE", length=250, nullable=false, unique=false)
	private String employmentType;
	
}
