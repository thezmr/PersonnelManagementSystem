package com.llz.renshi.move.domain;

public class Dismission {
	private int d_id;	//	��ְ��ţ��������Զ�����
	private Staff d_staffId;	//	Ա����ţ����
	private String d_date;	//	��ְ����
	private String d_type;	//	��ְ���ͣ�������ְ�����ˡ����ݡ�������������δͨ����
	private boolean d_pool;	//	�Ƿ�����˲ſ�
	public Dismission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dismission(Staff d_staffId, String d_date, String d_type, boolean d_pool) {
		super();
		this.d_staffId = d_staffId;
		this.d_date = d_date;
		this.d_type = d_type;
		this.d_pool = d_pool;
	}
	public Dismission(int d_id, Staff d_staffId, String d_date, String d_type, boolean d_pool) {
		super();
		this.d_id = d_id;
		this.d_staffId = d_staffId;
		this.d_date = d_date;
		this.d_type = d_type;
		this.d_pool = d_pool;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public Staff getD_staffId() {
		return d_staffId;
	}
	public void setD_staffId(Staff d_staffId) {
		this.d_staffId = d_staffId;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public boolean isD_pool() {
		return d_pool;
	}
	public void setD_pool(boolean d_pool) {
		this.d_pool = d_pool;
	}
	@Override
	public String toString() {
		return "Dismission [d_id=" + d_id + ", d_staffId=" + d_staffId + ", d_date=" + d_date + ", d_type=" + d_type
				+ ", d_pool=" + d_pool + "]";
	}

	
}
