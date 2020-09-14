package com.llz.renshi.job.service;

import java.util.ArrayList;

import com.llz.renshi.department.domain.Staff;
import com.llz.renshi.job.domain.Job;

public interface IJobService {
	//��ȡ��λ��������Ϣ
	public ArrayList<Job> queryJobs();
	
	//ͨ��������Ʋ��Ҹ�λ��Ϣ
	public ArrayList<Job> queryJobsById(int id);
	
	//ͨ�����Ʊ�����Ʋ��Ҹ�λ��Ϣ
	public ArrayList<Job> queryJobsByName(String name);
	
	//ͨ�����Ͳ��Ҹ�λ��Ϣ
	public ArrayList<Job> queryJobsByType(String type);
	
	//��ѯָ����λ�µ�ǰ��ְԱ����Ϣ
	public ArrayList<Staff> queryStaffsInJob(String Jobname);
	
	//�½�һ����λ
	public boolean insertJob(Job j);
	
	//�޸����и�λ����Ϣ
	public boolean updateJob(Job j);
	
	//ɾ��һ����λ
	public boolean deleteJobByName(Job j);
}
