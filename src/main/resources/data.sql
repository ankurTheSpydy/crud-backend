DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  employee_id VARCHAR(250)  PRIMARY KEY,
  employee_name VARCHAR(250) NOT NULL,
  department VARCHAR(250) NOT NULL,
  job_grade VARCHAR(250) NOT NULL,
  manager_name VARCHAR(250) NOT NULL,
  employment_type VARCHAR(250) NOT NULL
);

INSERT INTO employees VALUES 
('T001','Test User_1', 'Dept 1', 'D', 'M_Test User_1', 'Permanent'),
('T002','Test User_2', 'Dept 2', 'D', 'M_Test User_2', 'Permanent'),
('T003','Test User_3', 'Dept 1', 'D', 'M_Test User_1', 'Contract'),
('T004','Test User_4', 'Dept 2', 'C', 'M_Test User_2', 'Permanent'),
('T005','Test User_5', 'Dept 3', 'B', 'M_Test User_4', 'Contract'),
('T006','Test User_6', 'Dept 4', 'A', 'M_Test User_3', 'Permanent');
