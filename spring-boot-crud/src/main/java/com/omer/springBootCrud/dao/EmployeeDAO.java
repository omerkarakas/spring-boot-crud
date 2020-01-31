package com.omer.springBootCrud.dao;

import java.util.List;

import com.omer.springBootCrud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> listAll();
	
	public Employee getEmployee(int empId);
	
	public Employee save(Employee employee);
	
	public void delete(int empId);
	
}
