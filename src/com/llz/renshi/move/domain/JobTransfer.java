package com.llz.renshi.move.domain;

public class JobTransfer {
	private int	jt_id;	//	�������Զ�����
	private Job	jt_preJob;	//	��תǰ�ĸ�λ�����
	private Job	jt_job;	//	��ת��ĸ�λ�����
	private Staff jt_staffId;	//	��תԱ�������
	private String jt_type;	//	��ת���� ����ְ����ְ������¼�����
	private String jt_date;	//	��������
	public JobTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobTransfer(int jt_id, Job jt_preJob, Job jt_job, Staff jt_staffId, String jt_type, String jt_date) {
		super();
		this.jt_id = jt_id;
		this.jt_preJob = jt_preJob;
		this.jt_job = jt_job;
		this.jt_staffId = jt_staffId;
		this.jt_type = jt_type;
		this.jt_date = jt_date;
	}
	public JobTransfer(Job jt_preJob, Job jt_job, Staff jt_staffId, String jt_type, String jt_date) {
		super();
		this.jt_preJob = jt_preJob;
		this.jt_job = jt_job;
		this.jt_staffId = jt_staffId;
		this.jt_type = jt_type;
		this.jt_date = jt_date;
	}
	public int getJt_id() {
		return jt_id;
	}
	public void setJt_id(int jt_id) {
		this.jt_id = jt_id;
	}
	public Job getJt_preJob() {
		return jt_preJob;
	}
	public void setJt_preJob(Job jt_preJob) {
		this.jt_preJob = jt_preJob;
	}
	public Job getJt_job() {
		return jt_job;
	}
	public void setJt_job(Job jt_job) {
		this.jt_job = jt_job;
	}
	public Staff getJt_staffId() {
		return jt_staffId;
	}
	public void setJt_staffId(Staff jt_staffId) {
		this.jt_staffId = jt_staffId;
	}
	public String getJt_type() {
		return jt_type;
	}
	public void setJt_type(String jt_type) {
		this.jt_type = jt_type;
	}
	public String getJt_date() {
		return jt_date;
	}
	public void setJt_date(String jt_date) {
		this.jt_date = jt_date;
	}
	@Override
	public String toString() {
		return "JobTransfer [jt_id=" + jt_id + ", jt_preJob=" + jt_preJob + ", jt_job=" + jt_job + ", jt_staffId="
				+ jt_staffId + ", jt_type=" + jt_type + ", jt_date=" + jt_date + "]";
	}
	
}
