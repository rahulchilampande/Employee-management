package com.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.entity.Employee;
import com.CRUD.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	 private EmployeeService employeeService;
	

	@PostMapping
	 public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	 }
	 
     @GetMapping
     public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
    	 
     }
     
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
    	return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
     
     
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteEmployee(@PathVariable long id){
    	 employeeService.deleteEmployee(id);
    	 return new ResponseEntity<String>("Employee Deleted Succesfully!.", HttpStatus.OK );
    	 
     }
     
     @PutMapping("{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
//    	 return new ResponseEntity<Emplyee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    	 return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
     }
     
}
