package com.llz.renshi.move.domain;

public class StaffCheck {
	private int sc_id;	//���˱�ţ��������Զ�����
	private StaffTrail	sc_num;	//���ñ�ţ����
	private String sc_comment;	//�����ڲ��ſ�������
	private String sc_result;	//���˽����ת�������ڡ�����¼�ã�
	private String sc_date;	//��������
	public StaffCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffCheck(StaffTrail sc_num, String sc_comment, String sc_result, String sc_date) {
		super();
		this.sc_num = sc_num;
		this.sc_comment = sc_comment;
		this.sc_result = sc_result;
		this.sc_date = sc_date;
	}
	public StaffCheck(int sc_id, StaffTrail sc_num, String sc_comment, String sc_result, String sc_date) {
		super();
		this.sc_id = sc_id;
		this.sc_num = sc_num;
		this.sc_comment = sc_comment;
		this.sc_result = sc_result;
		this.sc_date = sc_date;
	}
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public StaffTrail getSc_num() {
		return sc_num;
	}
	public void setSc_num(StaffTrail sc_num) {
		this.sc_num = sc_num;
	}
	public String getSc_comment() {
		return sc_comment;
	}
	public void setSc_comment(String sc_comment) {
		this.sc_comment = sc_comment;
	}
	public String getSc_result() {
		return sc_result;
	}
	public void setSc_result(String sc_result) {
		this.sc_result = sc_result;
	}
	public String getSc_date() {
		return sc_date;
	}
	public void setSc_date(String sc_date) {
		this.sc_date = sc_date;
	}
	@Override
	public String toString() {
		return "StaffCheck [sc_id=" + sc_id + ", sc_num=" + sc_num + ", sc_comment=" + sc_comment + ", sc_result="
				+ sc_result + ", sc_date=" + sc_date + "]";
	}

	
}
