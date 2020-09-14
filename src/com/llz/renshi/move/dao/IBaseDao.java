package com.llz.renshi.move.dao;

import java.util.ArrayList;

import com.llz.renshi.move.domain.Base;



public interface IBaseDao {
	public boolean insertBase(Base base);
	public boolean updateBase(Base base);
	public boolean deleteBase(Base base);//ͨ��Ա�����ɾ���˲ſ��¼
	
	public ArrayList<Base> queryById(int id);
	public ArrayList<Base> queryByStaffId(int staffId);
}
