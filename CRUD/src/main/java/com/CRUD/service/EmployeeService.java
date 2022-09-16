package com.CRUD.service;

import java.util.List;
import java.util.Optional;

import com.CRUD.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long id);
	
	void deleteEmployee(long id);
	
	Employee updateEmployee(Employee employee, Long id);
}
