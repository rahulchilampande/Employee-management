package com.CRUD.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.entity.Employee;
import com.CRUD.exception.ResourceNotFoundException;
import com.CRUD.repository.EmployeeRepository;
import com.CRUD.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}


	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}


	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));

	}


	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		// TODO Auto-generated method stub
		Employee exitEmployee= employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
		
		exitEmployee.setFirstName(employee.getFirstName());
		exitEmployee.setLastName(employee.getLastName());
		exitEmployee.setEmail(employee.getEmail());

         employeeRepository.save(exitEmployee);
         return exitEmployee;
	}
	
	
	
}
