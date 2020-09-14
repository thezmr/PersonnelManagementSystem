package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.dao.IStaffTrailDao;
import com.llz.renshi.move.dao.StaffTrailDao;
import com.llz.renshi.move.domain.StaffTrail;



public class StaffTrailService implements IStaffTrailService {

	@Override
	public boolean insertStaffTrail(StaffTrail sc) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.insertStaffTrail(sc);
	}

	@Override
	public boolean updateStaffTrail(StaffTrail sc) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.updateStaffTrail(sc);
	}

	@Override
	public boolean deleteStaffTrail(StaffTrail sc) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.deleteStaffTrail(sc);
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailById(int id) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.queryStaffTrailById(id);
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailByStaffId(int StaffId) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.queryStaffTrailByStaffId(StaffId);
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailBysDate(String sDate) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.queryStaffTrailBysDate(sDate);
	}

	@Override
	public ArrayList<StaffTrail> queryStaffTrailByeDate(String eDate) {
		IStaffTrailDao ists = new StaffTrailDao();
		return ists.queryStaffTrailByeDate(eDate);
	}

}
