package com.llz.renshi.department.service;

import java.util.ArrayList;

import com.llz.renshi.department.domain.Department;
import com.llz.renshi.department.domain.Staff;

public interface IDepartmentService {
	//��ȡ���ű�������Ϣ
	public ArrayList<Department> queryDepartments();
	
	//ͨ��������Ʋ��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsById(int id);
	
	//ͨ�����Ʊ�����Ʋ��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsByName(String name);
	
	//ͨ�����Ͳ��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsByType(String type);
	
	//��ѯָ�������µ�ǰ��ְԱ����Ϣ
	public ArrayList<Staff> queryStaffsInDep(String departmentname);
	
	//�½�һ������
	public boolean insertDepartment(Department d);
	
	//�޸����в��ŵ���Ϣ
	public boolean updateDepartment(Department d);
	
	//ɾ��һ������
	public boolean deleteDepartmentByName(Department d);
}
