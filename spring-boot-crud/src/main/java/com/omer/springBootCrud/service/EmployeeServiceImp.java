package com.omer.springBootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omer.springBootCrud.dao.EmployeeDAO;
import com.omer.springBootCrud.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> listAll() {
	
		return employeeDAO.listAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int empId) {
	
		return employeeDAO.getEmployee(empId);
		
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
	
		return employeeDAO.save(employee);
	
	}

	@Override
	@Transactional
	public void delete(int empId) {

		employeeDAO.delete(empId);
	
	}

}
