package com.llz.renshi.employee.domain;

public class Department {
	private int departmentid;
	private String departmentname;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(int departmentid, String departmentname) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}


	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	
	
}
