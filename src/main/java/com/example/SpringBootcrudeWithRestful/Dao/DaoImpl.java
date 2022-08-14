package com.example.SpringBootcrudeWithRestful.Dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootcrudeWithRestful.Model.Employee;

public class DaoImpl implements DaoI{

	@Autowired
	private SessionFactory sf;
	
	
	
	@Override
	public int saveEmployeeDao(Employee emp) {
		Session session = sf.openSession();
		session.beginTransaction();
		int id = (int)session.save(emp);
		System.out.println(id);
		session.getTransaction().commit();
		return id;
	}


	@Override
	public List<Employee> getAllEmployeeDao() {
		Session session = sf.openSession();
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		return  list;
	
	}

	@Override
	public Employee update(Integer empId) {
		Session session = sf.openSession();
		Employee emp=session.get(Employee.class, empId);
		return emp;
		
	}


	@Override
	public Employee Logincheck(Employee emp) {
		Session session = sf.openSession();
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List <Employee>list = query.getResultList();
		
		for(Employee emp1:list) {
			
			if (emp.getEmpName().equals(emp1.getEmpName())&&(emp.getEmpAddress().equals(emp1.getEmpAddress()))) {
		return emp1;
	}
}
		return null;
	}


	@Override
	public boolean deleteById(int empId) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, empId);
		if (employee !=null) {
			session.delete(employee);
			session.getTransaction().commit();
			session.close();
		}
		return false;
		
		
		
	}

	
}
	