package com.llz.renshi.move.domain;

public class Job {
	private int j_id;//�������Զ�����
	private String j_name;//��λ����
	private String j_type;//��λ���ͣ�����������Ӫ�����г���
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(String j_name, String j_type) {
		super();
		this.j_name = j_name;
		this.j_type = j_type;
	}
	public Job(int j_id, String j_name, String j_type) {
		super();
		this.j_id = j_id;
		this.j_name = j_name;
		this.j_type = j_type;
	}
	
	public int getJ_id() {
		return j_id;
	}
	public void setJ_id(int j_id) {
		this.j_id = j_id;
	}
	public String getJ_name() {
		return j_name;
	}
	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}
	public String getJ_type() {
		return j_type;
	}
	public void setJ_type(String j_type) {
		this.j_type = j_type;
	}
	
	
}
