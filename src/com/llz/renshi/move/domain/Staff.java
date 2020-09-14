package com.llz.renshi.move.domain;

public class Staff {
	private int s_id;	//Ա���ţ��������Զ�����
	private String s_name;	//����
	private String s_sex;	//�Ա�1�У�2Ů��
	private String s_birthday;	//��������
	private Department s_departmentId;	//���źţ����
	private Job s_jobId;		//��λ�ţ����
	private String s_date;		//��ְ����
	private String s_jsDate;	//�μӹ�������
	private String s_eInformation;	//�ù���ʽ����ʽԱ������ʱԱ����
	private String s_pSource;	//��Ա��Դ��У԰��Ƹ�������Ƹ��������
	private String s_Tel;		//��ϵ�绰
	private String s_email; 	//�����ʼ�
	private String s_education;	//���ѧ�������м����£���ר�����ƣ��о�����
	private String s_exprience;	//ĳһ�׶δ��¹�����ѧϰ����
	private String s_esDate;	//�ý׶ε���ʼ����
	private String s_eeDate;	//�ý׶εĽ�ֹ����
	private String s_fLanguage;	//������֣�Ӣ�������
	private String s_fName;		//Ա������������
	private String s_fRelation;	//Ա�������뱾�˹�ϵ�����ס�ĸ�ס���ż��
	private boolean s_dismission;	//�Ƿ���ְ
	private String s_idNum;		//���֤��
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String s_name, String s_sex, String s_birthday, Department s_departmentId, Job s_jobId, String s_date,
			String s_jsDate, String s_eInformation, String s_pSource, String s_Tel, String s_email, String s_education,
			String s_exprience, String s_esDate, String s_eeDate, String s_fLanguage, String s_fName,
			String s_fRelation, boolean s_dismission, String s_idNum) {
		super();
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_birthday = s_birthday;
		this.s_departmentId = s_departmentId;
		this.s_jobId = s_jobId;
		this.s_date = s_date;
		this.s_jsDate = s_jsDate;
		this.s_eInformation = s_eInformation;
		this.s_pSource = s_pSource;
		this.s_Tel = s_Tel;
		this.s_email = s_email;
		this.s_education = s_education;
		this.s_exprience = s_exprience;
		this.s_esDate = s_esDate;
		this.s_eeDate = s_eeDate;
		this.s_fLanguage = s_fLanguage;
		this.s_fName = s_fName;
		this.s_fRelation = s_fRelation;
		this.s_dismission = s_dismission;
		this.s_idNum = s_idNum;
	}
	public Staff(int s_id, String s_name, String s_sex, String s_birthday, Department s_departmentId, Job s_jobId,
			String s_date, String s_jsDate, String s_eInformation, String s_pSource, String s_Tel, String s_email,
			String s_education, String s_exprience, String s_esDate, String s_eeDate, String s_fLanguage,
			String s_fName, String s_fRelation, boolean s_dismission, String s_idNum) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_birthday = s_birthday;
		this.s_departmentId = s_departmentId;
		this.s_jobId = s_jobId;
		this.s_date = s_date;
		this.s_jsDate = s_jsDate;
		this.s_eInformation = s_eInformation;
		this.s_pSource = s_pSource;
		this.s_Tel = s_Tel;
		this.s_email = s_email;
		this.s_education = s_education;
		this.s_exprience = s_exprience;
		this.s_esDate = s_esDate;
		this.s_eeDate = s_eeDate;
		this.s_fLanguage = s_fLanguage;
		this.s_fName = s_fName;
		this.s_fRelation = s_fRelation;
		this.s_dismission = s_dismission;
		this.s_idNum = s_idNum;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_birthday() {
		return s_birthday;
	}
	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}
	public Department getS_departmentId() {
		return s_departmentId;
	}
	public void setS_departmentId(Department s_departmentId) {
		this.s_departmentId = s_departmentId;
	}
	public Job getS_jobId() {
		return s_jobId;
	}
	public void setS_jobId(Job s_jobId) {
		this.s_jobId = s_jobId;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getS_jsDate() {
		return s_jsDate;
	}
	public void setS_jsDate(String s_jsDate) {
		this.s_jsDate = s_jsDate;
	}
	public String getS_eInformation() {
		return s_eInformation;
	}
	public void setS_eInformation(String s_eInformation) {
		this.s_eInformation = s_eInformation;
	}
	public String getS_pSource() {
		return s_pSource;
	}
	public void setS_pSource(String s_pSource) {
		this.s_pSource = s_pSource;
	}
	public String getS_Tel() {
		return s_Tel;
	}
	public void setS_Tel(String s_Tel) {
		this.s_Tel = s_Tel;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_education() {
		return s_education;
	}
	public void setS_education(String s_education) {
		this.s_education = s_education;
	}
	public String getS_exprience() {
		return s_exprience;
	}
	public void setS_exprience(String s_exprience) {
		this.s_exprience = s_exprience;
	}
	public String getS_esDate() {
		return s_esDate;
	}
	public void setS_esDate(String s_esDate) {
		this.s_esDate = s_esDate;
	}
	public String getS_eeDate() {
		return s_eeDate;
	}
	public void setS_eeDate(String s_eeDate) {
		this.s_eeDate = s_eeDate;
	}
	public String getS_fLanguage() {
		return s_fLanguage;
	}
	public void setS_fLanguage(String s_fLanguage) {
		this.s_fLanguage = s_fLanguage;
	}
	public String getS_fName() {
		return s_fName;
	}
	public void setS_fName(String s_fName) {
		this.s_fName = s_fName;
	}
	public String getS_fRelation() {
		return s_fRelation;
	}
	public void setS_fRelation(String s_fRelation) {
		this.s_fRelation = s_fRelation;
	}
	public boolean isS_dismission() {
		return s_dismission;
	}
	public void setS_dismission(boolean s_dismission) {
		this.s_dismission = s_dismission;
	}
	public String getS_idNum() {
		return s_idNum;
	}
	public void setS_idNum(String s_idNum) {
		this.s_idNum = s_idNum;
	}
	@Override
	public String toString() {
		return "Staff [s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_birthday=" + s_birthday
				+ ", s_departmentId=" + s_departmentId + ", s_jobId=" + s_jobId + ", s_date=" + s_date + ", s_jsDate="
				+ s_jsDate + ", s_eInformation=" + s_eInformation + ", s_pSource=" + s_pSource + ", s_Tel=" + s_Tel
				+ ", s_email=" + s_email + ", s_education=" + s_education + ", s_exprience=" + s_exprience
				+ ", s_esDate=" + s_esDate + ", s_eeDate=" + s_eeDate + ", s_fLanguage=" + s_fLanguage + ", s_fName="
				+ s_fName + ", s_fRelation=" + s_fRelation + ", s_dismission=" + s_dismission + ", s_idNum=" + s_idNum
				+ "]";
	}
	
	

}
