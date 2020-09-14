package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.dao.IStaffCheckDao;
import com.llz.renshi.move.dao.StaffCheckDao;
import com.llz.renshi.move.domain.StaffCheck;



public class StaffCheckService implements IStaffCheckService {

	@Override
	public boolean insertStaffCheck(StaffCheck st) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.insertStaffCheck(st);
	}

	@Override
	public boolean updateStaffCheck(StaffCheck st) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.updateStaffCheck(st);
	}

	@Override
	public boolean deleteStaffCheck(StaffCheck st) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.deleteStaffCheck(st);
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckById(int id) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.queryStaffCheckById(id);
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByNum(int scId) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.queryStaffCheckByNum(scId);
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByResult(String result) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.queryStaffCheckByResult(result);
	}

	@Override
	public ArrayList<StaffCheck> queryStaffCheckByDate(String date) {
		IStaffCheckDao iscs = new StaffCheckDao();
		return iscs.queryStaffCheckByDate(date);
	}

}
