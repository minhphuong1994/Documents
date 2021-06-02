CREATE DATABASE SIMPLEDB;

CREATE TABLE department (
	department_id INT IDENTITY(1,1) PRIMARY KEY,
	department_name VARCHAR (30) NOT NULL,
);

CREATE TABLE employee (
	employee_id INT IDENTITY(1,1) PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	hire_date DATE NOT NULL,
	salary DECIMAL (8, 2) NOT NULL,
	department_id INT DEFAULT NULL,
	FOREIGN KEY (department_id) REFERENCES department (department_id) ON DELETE CASCADE ON UPDATE CASCADE,
);
