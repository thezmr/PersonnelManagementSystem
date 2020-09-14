package com.llz.renshi.move.domain;

public class StaffTrail {
	private int st_id;	//�����ڱ�ţ��������Զ�����
	private Staff st_staffId;//Ա���ţ����
	private String st_tsDate;//�����ڿ�ʼ����
	private String st_teDate;//�����ڽ�������
	public StaffTrail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffTrail(Staff st_staffId, String st_tsDate, String st_teDate) {
		super();
		this.st_staffId = st_staffId;
		this.st_tsDate = st_tsDate;
		this.st_teDate = st_teDate;
	}
	public StaffTrail(int st_id, Staff st_staffId, String st_tsDate, String st_teDate) {
		super();
		this.st_id = st_id;
		this.st_staffId = st_staffId;
		this.st_tsDate = st_tsDate;
		this.st_teDate = st_teDate;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public Staff getSt_staffId() {
		return st_staffId;
	}
	public void setSt_staffId(Staff st_staffId) {
		this.st_staffId = st_staffId;
	}
	public String getSt_tsDate() {
		return st_tsDate;
	}
	public void setSt_tsDate(String st_tsDate) {
		this.st_tsDate = st_tsDate;
	}
	public String getSt_teDate() {
		return st_teDate;
	}
	public void setSt_teDate(String st_teDate) {
		this.st_teDate = st_teDate;
	}
	@Override
	public String toString() {
		return "StraffTrail [st_id=" + st_id + ", st_staffId=" + st_staffId + ", st_tsDate=" + st_tsDate
				+ ", st_teDate=" + st_teDate + "]";
	}
	
}
