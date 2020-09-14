package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.dao.DismissionDao;
import com.llz.renshi.move.dao.IDismissionDao;
import com.llz.renshi.move.domain.Dismission;



public class DismissionService implements IDismissionService  {

	@Override
	public boolean insertDismission(Dismission dismission) {
		IDismissionDao ids = new DismissionDao();
		return ids.insertDismission(dismission);
	}

	@Override
	public boolean updateDismission(Dismission dismission) {
		IDismissionDao ids = new DismissionDao();
		return ids.updateDismission(dismission);
	}

	@Override
	public boolean deleteDismission(Dismission dismission) {
		IDismissionDao ids = new DismissionDao();
		return ids.deleteDismission(dismission);
	}

	@Override
	public ArrayList<Dismission> querydById(int id) {
		IDismissionDao ids = new DismissionDao();
		return ids.querydById(id);
	}

	@Override
	public ArrayList<Dismission> querydByStaffId(int staffId) {
		IDismissionDao ids = new DismissionDao();
		return ids.querydByStaffId(staffId);
	}

	@Override
	public ArrayList<Dismission> querydByDate(String date) {
		IDismissionDao ids = new DismissionDao();
		return ids.querydByDate(date);
	}

	@Override
	public ArrayList<Dismission> querydByType(String type) {
		IDismissionDao ids = new DismissionDao();
		return ids.querydByType(type);
	}

	@Override
	public ArrayList<Dismission> querydByPool(boolean pool) {
		IDismissionDao ids = new DismissionDao();
		return ids.querydByPool(pool);
	}

}
