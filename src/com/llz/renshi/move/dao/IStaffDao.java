package com.llz.renshi.move.dao;

import java.util.ArrayList;

import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.Job;
import com.llz.renshi.move.domain.Staff;

public interface IStaffDao {
	public boolean insertStaff(Staff s);//����Ա����¼��
	
	public ArrayList<Staff> queryStaffByBase();//��ѯ�������˲ſ��е�Ա��
	public ArrayList<Staff> queryStaffByDis();//��ѯ������ְ��Ա��
	public Staff queryStaffByIdNum(String idNum);//ͨ�����֤�Ų�ѯid
	
	public boolean updateStaffDismissionById(Staff s);//����Ա������ְ���ֻҪid���Ժ���ְ����
	public boolean updateStaffDepartmentById(Staff s);//����Ա���Ĳ�����Ϣ��ֻҪid���ԺͲ�������
	public boolean updateStaffJobById(Staff s);//����Ա���ĸ�λ��Ϣ��ֻҪid���Ժ͸�λ����
	
	public ArrayList<Staff> queryStaffTrailByDepartment(Department dep);//ͨ���������Ʋ����� ��Ա��
	public ArrayList<Staff> queryStaffTrailByJob(Job job);//ͨ����λ���Ʋ����� ��Ա��

	public ArrayList<Staff> queryStaffByDepartment(Department dep);//ͨ���������Ʋ���Ա��, ģ����ѯ
	public ArrayList<Staff> queryStaffByJob(Job job);//ͨ����λ���Ʋ���Ա��, ģ����ѯ

	
	public ArrayList<Staff> queryStaffCheckByDepartment(Department dep);//ͨ���������Ʋ���ת��Ա��
	public ArrayList<Staff> queryStaffCheckByJob(Job job);//ͨ����λ���Ʋ���ת��Ա��
}
