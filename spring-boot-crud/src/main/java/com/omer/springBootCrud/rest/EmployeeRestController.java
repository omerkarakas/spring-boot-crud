package com.omer.springBootCrud.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omer.springBootCrud.dao.EmployeeDAO;
import com.omer.springBootCrud.entity.Employee;
import com.omer.springBootCrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//simdilik : inject dao 
	//private EmployeeDAO employeeDAO;
	
	private EmployeeService employeeService;
	

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	//expose /employees and return list of emps
	@GetMapping("/employees")
	public List<Employee> listAll(){
		return employeeService.listAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee result = employeeService.getEmployee(employeeId);
		if (result==null)
			throw new RuntimeException("No such employeeId:"+employeeId);
		
		return result;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
		
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp==null)
			throw new RuntimeException("No such emp to be deleted: "+ employeeId);
			
		employeeService.delete(employeeId);
		return "Deleted employee with id:"+employeeId;
	}
}
