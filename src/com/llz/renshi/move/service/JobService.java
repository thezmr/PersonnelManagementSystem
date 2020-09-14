package com.llz.renshi.move.service;

import com.llz.renshi.move.dao.IJobDao;
import com.llz.renshi.move.dao.JobDao;
import com.llz.renshi.move.domain.Job;

public class JobService implements IJobService {

	@Override
	public Job queryIdJobsByName(String name) {
		IJobDao ijd = new JobDao();
		return ijd.queryIdJobsByName(name);
	}
//	public static void main(String [] args) {
//		IJobService idd =new JobService();
//		Job ds = idd.queryIdJobsByName("�ɹ�����");
//		System.out.print(ds.getJ_id());
//	}
}
