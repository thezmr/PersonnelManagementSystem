package com.llz.renshi.employee.service;

import java.util.ArrayList;

import com.llz.renshi.employee.dao.IJobDao;
import com.llz.renshi.employee.dao.JobDao;
import com.llz.renshi.employee.domain.Job;


public class JobService implements IJobService {

	@Override
	public ArrayList<Job> queryJob() {
		IJobDao jd = new JobDao();
		return jd.getAllJNames(); 

	}

}
