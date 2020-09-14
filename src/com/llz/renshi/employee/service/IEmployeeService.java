package com.llz.renshi.employee.service;

import java.util.ArrayList;

import com.llz.renshi.employee.domain.Employee;


public interface IEmployeeService {
	public ArrayList<Employee> queryEmployee(String productname);
	public Employee queryEmployeeByID(int id);
	public boolean updateEmployee(Employee p);

}
