package com.example.SpringBootcrudeWithRestful.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringBootcrudeWithRestful.Model.Employee;

@Repository
public interface DaoI {

	
   public int saveEmployeeDao(Employee emp);

	public List<Employee> getAllEmployeeDao();
	
	public Employee update(Integer empId);
	
	public Employee Logincheck(Employee emp);
	
	boolean deleteById(int empId);


	
	

	
}
