package com.llz.renshi.employee.service;

import java.util.ArrayList;

import com.llz.renshi.employee.dao.EmployeeDao;
import com.llz.renshi.employee.dao.IEmployeeDao;
import com.llz.renshi.employee.domain.Employee;


public class EmployeeService implements IEmployeeService{

	@Override
	public ArrayList<Employee> queryEmployee(String employeename) {
		IEmployeeDao pd = new EmployeeDao();	
		return pd.queryEmployee(employeename);
	}

	@Override
	public boolean updateEmployee(Employee p) {
		IEmployeeDao pd = new EmployeeDao();	
		return pd.updateEmployee(p);
	}

	@Override
	public Employee queryEmployeeByID(int id) {
		IEmployeeDao pd = new EmployeeDao();	
		return pd.queryEmployee(id);
	}

}
