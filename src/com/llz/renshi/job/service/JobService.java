package com.llz.renshi.job.service;

import java.util.ArrayList;

import com.llz.renshi.department.domain.Staff;
import com.llz.renshi.job.dao.IJobDao;
import com.llz.renshi.job.dao.JobDao;
import com.llz.renshi.job.domain.Job;



public class JobService implements IJobService{
	
	@Override
	public ArrayList<Job> queryJobs() {

		IJobDao j = new JobDao();
		return j.queryJobs();
	}

	@Override
	public ArrayList<Job> queryJobsById(int id) {
		IJobDao j = new JobDao();
		return j.queryJobsById(id);
	}

	@Override
	public ArrayList<Job> queryJobsByName(String name) {
		IJobDao j = new JobDao();
		return j.queryJobsByName(name);
	}

	@Override
	public ArrayList<Job> queryJobsByType(String type) {
		IJobDao j = new JobDao();
		return j.queryJobsByType(type);
	}

	@Override
	public ArrayList<Staff> queryStaffsInJob(String Jobname) {
		IJobDao j = new JobDao();
		return j.queryStaffsInJob(Jobname);
	}

	@Override
	public boolean insertJob(Job d) {
		IJobDao ij = new JobDao();
		return ij.insertJob(d);
	}

	@Override
	public boolean updateJob(Job d) {
		IJobDao ij = new JobDao();
		return ij.updateJob(d);
	}

	@Override
	public boolean deleteJobByName(Job j) {
		IJobDao ij = new JobDao();
		return ij.deleteJobByName(j);
	}

//	public static void main(String[] args) {
//		IJobDao j = new JobDao();
//		Job job = new Job(3,"��","����",1);
//		j.queryStaffsInDep("ִ���ܲ�");
//		//d.updateDepartment(dep);
//
//	}

}
