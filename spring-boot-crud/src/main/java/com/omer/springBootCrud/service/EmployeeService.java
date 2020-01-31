package com.omer.springBootCrud.service;

import java.util.List;

import com.omer.springBootCrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> listAll();
	
	public Employee getEmployee(int empId);
	
	public Employee save(Employee employee);
	
	public void delete(int empId);
	
}
