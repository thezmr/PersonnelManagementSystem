package com.llz.renshi.department.domain;

public class Department {
	private int d_id;//���ź�
	private String d_name;//��������
	private String d_type;//����
	private String d_tel;//�绰
	private String d_date;//��������
	public Department(int d_id, String d_name, String d_type, String d_tel, String d_date) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_type = d_type;
		this.d_tel = d_tel;
		this.d_date = d_date;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public String getD_tel() {
		return d_tel;
	}
	public void setD_tel(String d_tel) {
		this.d_tel = d_tel;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public Department(String d_name, String d_type, String d_tel, String d_date) {
		super();
		this.d_name = d_name;
		this.d_type = d_type;
		this.d_tel = d_tel;
		this.d_date = d_date;
	}
	public Department() {
		super();
	}
	
	
}
