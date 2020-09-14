package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.domain.Dismission;

public interface IDismissionService {
	//����ְ���в�����ְ��¼
		public boolean insertDismission(Dismission dismission);
		public boolean updateDismission(Dismission dismission);
		public boolean deleteDismission(Dismission dismission);
		
		//ͨ����ˮ��Ų��Ҹ�λ������Ϣ��
		//ע����Щ��ѯ ���ص�Staff����ֻ�б�ź����ơ�
		public ArrayList<Dismission> querydById(int id);
		public ArrayList<Dismission> querydByStaffId(int staffId);
		public ArrayList<Dismission> querydByDate(String date);
		public ArrayList<Dismission> querydByType(String type);
		public ArrayList<Dismission> querydByPool(boolean pool);
}
