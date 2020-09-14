package com.llz.renshi.move.service;

import java.util.ArrayList;

import com.llz.renshi.move.domain.StaffTrail;



public interface IStaffTrailService {
	public boolean insertStaffTrail(StaffTrail st);
	
	public boolean updateStaffTrail(StaffTrail st);
	public boolean deleteStaffTrail(StaffTrail st);
	
	public ArrayList<StaffTrail> queryStaffTrailById(int id);
	public ArrayList<StaffTrail> queryStaffTrailByStaffId(int StaffId);
	public ArrayList<StaffTrail> queryStaffTrailBysDate(String sDate);
	public ArrayList<StaffTrail> queryStaffTrailByeDate(String eDate);
}
