package com.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		
		
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getEmpl() {
		
		return employeeRepository.findAll();

}
	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee= employeeRepository.findById(id);
//		if(employee.isPresent())
//		{
//		return employee.get();
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee", "Id", id);
//	}
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setMail(employee.getMail());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deletEmployee(long id) {
		
		//check whether a employee exist in a Database or not
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
	
		employeeRepository.deleteById(id);
	}
}
