package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.domain.DepartmentTransfer;
import com.llz.renshi.move.domain.Staff;



public interface IDepartmentManagementService {
	//���ŵ���������¼
		public boolean insertDepartmentTransfer(DepartmentTransfer dt);
		public boolean updateDepartmentTransfer(DepartmentTransfer dt);
		public boolean deleteDepartmentTransfer(DepartmentTransfer dt);
		
		//ͨ����ˮ��Ų��Ҳ��ŵ�����Ϣ��
		//ע����Щ��ѯ ���ص�Department��Staff����ֻ�б�ź����ơ�
		public ArrayList<DepartmentTransfer> querydtById(int id);
		
		//ͨ����תǰ���ŵ����Ʋ��Ҳ��ŵ�����Ϣ
		public ArrayList<DepartmentTransfer> querydtByPreDepName(String preDepName);
		public ArrayList<DepartmentTransfer> querydtByDepName(String DepName);
		
		//ͨ����תǰ���ŵ�id���Ҳ��ŵ�����Ϣ
		public ArrayList<DepartmentTransfer> querydtByPreDepId(int preDepId);
		//ͨ����ת���ŵ�id���Ҳ��ŵ�����Ϣ	
		public ArrayList<DepartmentTransfer> querydtByDepId(int depId);
		//ͨ����תԱ��id���Ҳ��ŵ�����Ϣ		
		public ArrayList<DepartmentTransfer> querydtByStaffId(int staffId);
		//ͨ����ת���Ͳ��Ҳ��ŵ�����Ϣ		
		public ArrayList<DepartmentTransfer> querydtByType(String type);
		//ͨ����ת���ڲ��Ҳ��ŵ�����Ϣ		
		public ArrayList<DepartmentTransfer> querydtByDate(String date);
		
//		public ArrayList<Staff> queryDepartmentTransferStaffByDate(String date);//��ѯҪ��Ա��
		//��λҪ�������ŵ�Ա��
		public ArrayList<Staff> queryDepartmentTransferStaffb(String departmentName);//��ѯ�ò��ŵ��ߵ�Ա��
		public ArrayList<Staff> queryDepartmentTransferStaffa(String departmentName);//��ѯ�ò��ŵ����Ա��
}
