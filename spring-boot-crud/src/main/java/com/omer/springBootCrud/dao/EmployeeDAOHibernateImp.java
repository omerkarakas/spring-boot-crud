package com.omer.springBootCrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omer.springBootCrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> listAll() {

		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		
		return query.getResultList();
	}


	@Override
	public Employee getEmployee(int empId) {

		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, empId);
		
		return employee;
	}


	@Override
	public Employee save(Employee employee) {

		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);

		return employee;
	}


	@Override
	public void delete(int empId) {

		Session session = entityManager.unwrap(Session.class);
		
		Employee emp = getEmployee(empId);
		
		session.delete(emp);
		
		//veya
/*		Query query = session.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", empId);
		query.executeUpdate();
*/		
	}


}
