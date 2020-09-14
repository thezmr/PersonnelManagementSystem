package com.llz.renshi.move.service;

import com.llz.renshi.move.dao.DepartmentDao;
import com.llz.renshi.move.dao.IDepartmentDao;
import com.llz.renshi.move.domain.Department;

public class DepartmentService implements IDepartmentService {

	@Override
	public Department queryIdDepartmentsByName(String name) {
		IDepartmentDao ids = new DepartmentDao ();
		return ids.queryIdDepartmentsByName(name);
	}
//	public static void main(String [] args) {
//		IDepartmentService idd =new DepartmentService();
//		Department ds = idd.queryIdDepartmentsByName("���۲���");
//		System.out.print(ds.getD_id());
//	}
}
