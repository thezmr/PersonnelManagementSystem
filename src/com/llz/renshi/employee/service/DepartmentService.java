package com.llz.renshi.employee.service;

import java.util.ArrayList;

import com.llz.renshi.employee.dao.DepartmentDao;
import com.llz.renshi.employee.dao.IDepartmentDao;
import com.llz.renshi.employee.domain.Department;

public class DepartmentService implements IDepartmentService {

	@Override
	public ArrayList<Department> queryDepartment() {
		IDepartmentDao de = new DepartmentDao();
		return de.getAllDNames();
	}

}
