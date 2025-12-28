package com.spring.service;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeService {
	

	Employee saveEmployee(Employee employee);
	
	List<Employee> getEmpl();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deletEmployee(long id);
	
	
	
}
