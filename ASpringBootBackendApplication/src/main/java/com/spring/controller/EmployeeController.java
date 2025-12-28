package com.spring.controller;

import java.util.List;

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

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeService;

	public EmployeeController(EmployeeService employeService) {
		super();
		this.employeService = employeService;
	}
	
	
	//create employee rest apis

	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	//GET ALL EMPLOYEE  rest API
	@GetMapping()
	public List<Employee> getEmployee()
	{
		return employeService.getEmpl();
	}
	
	
	// build get employee by id rest api 
	// http://localhost:9888/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeService.getEmployeeById(employeeId), HttpStatus.OK);
				
	}
	
	
	//build update employee REST API 
    //http://localhost:9888/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	
	//Build Delete Employee REST API
	//http://localhost:9888/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		//delete employee from DB
		employeService.deletEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!!", HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
