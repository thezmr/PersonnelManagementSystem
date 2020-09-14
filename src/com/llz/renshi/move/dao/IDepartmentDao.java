package com.llz.renshi.move.dao;

import com.llz.renshi.move.domain.Department;

public interface IDepartmentDao {
	//ͨ�����Ʊ�����Ʋ��Ҳ�����Ϣ
	public Department queryIdDepartmentsByName(String name);
}
