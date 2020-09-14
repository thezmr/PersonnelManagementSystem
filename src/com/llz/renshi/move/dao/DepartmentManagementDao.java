package com.llz.renshi.move.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.llz.renshi.department.dao.DBUtil;
import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.DepartmentTransfer;
import com.llz.renshi.move.domain.Job;
import com.llz.renshi.move.domain.Staff;


public class DepartmentManagementDao implements IDepartmentManagementDao {

	@Override
	public boolean insertDepartmentTransfer(DepartmentTransfer dt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="insert into department_transfer (DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,"
				+ "DT_TYPE,DT_REASON,DT_DATE) "
				+"values (?,?,?,?,?,?)";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, dt.getDt_preDepartment().getD_id());
			psp.setInt(2, dt.getDt_department().getD_id());
			psp.setInt(3, dt.getDt_staffID().getS_id());
			psp.setString(4, dt.getDt_type());
			psp.setString(5, dt.getDt_reason());
			psp.setString(6, dt.getDt_date());
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}

	@Override
	public boolean updateDepartmentTransfer(DepartmentTransfer dt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="update department_transfer "
				+ " SET DT_PRE_DEPARTMENT = ? ,DT_DEPARTMENT = ?,DT_STAFFID = ?,"
				+ "DT_TYPE = ?,DT_REASON = ? ,DT_DATE = ? "
				+" WHERE DT_ID = ?";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, dt.getDt_preDepartment().getD_id());
			psp.setInt(2, dt.getDt_department().getD_id());
			psp.setInt(3, dt.getDt_staffID().getS_id());
			psp.setString(4, dt.getDt_type());
			psp.setString(5, dt.getDt_reason());
			psp.setString(6, dt.getDt_date());
			psp.setInt(7, dt.getDt_id());
			
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}
	
	@Override
	public boolean deleteDepartmentTransfer(DepartmentTransfer dt) {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="delete from department_transfer "
				+" WHERE DT_ID = ?";
		
		PreparedStatement psp = null;
		try {
			psp = conn.prepareStatement(sql);
			psp.setInt(1, dt.getDt_id());
			
			psp.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(psp,conn);
		}
		return true;
	}
	
	@Override
	public ArrayList<DepartmentTransfer> querydtById(int id) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "dt.DT_ID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
	
	@Override
	public ArrayList<DepartmentTransfer> querydtByPreDepId(int preDepId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "dt.DT_PRE_DEPARTMENT = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,preDepId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
	@Override
	public ArrayList<DepartmentTransfer> querydtByDepId(int DepId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "dt.DT_DEPARTMENT = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,DepId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
	
	@Override
	public ArrayList<DepartmentTransfer> querydtByStaffId(int staffId) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "dt.DT_STAFFID = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,staffId);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByType(String type) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ " dt.DT_TYPE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,type);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByDate(String date) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ " dt.DT_DATE = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
	
	@Override
	public ArrayList<Staff> queryDepartmentTransferStaffb(String departmentName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from department_transfer dt,Staff s, department d,job j"
				+ " where dt.DT_STAFFID = s.S_ID AND dt.DT_PRE_DEPARTMENT = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND d.D_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+departmentName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				String s_name = rs.getString(2);	//����
				String s_sex = rs.getString(3);	//�Ա�1�У�2Ů��
				String s_birthday = rs.getString(4);	//��������				
				int d_id = rs.getInt(5);	//���źţ����
				int j_id = rs.getInt(6);	//��λ�ţ����
				 
				String s_date = rs.getString(7);		//��ְ����
				String s_jsDate = rs.getString(8);	//�μӹ�������
				String s_eInformation = rs.getString(9);	//�ù���ʽ����ʽԱ������ʱԱ����
				String s_pSource = rs.getString(10);	//��Ա��Դ��У԰��Ƹ�������Ƹ��������
				String s_Tel = rs.getString(11);		//��ϵ�绰
				
				String s_email = rs.getString(12); 	//�����ʼ�
				String s_education = rs.getString(13);	//���ѧ�������м����£���ר�����ƣ��о�����
				String s_exprience = rs.getString(14);	//ĳһ�׶δ��¹�����ѧϰ����
				String s_esDate = rs.getString(15);	//�ý׶ε���ʼ����
				String s_eeDate = rs.getString(16);	//�ý׶εĽ�ֹ����
				
				String s_fLanguage = rs.getString(17);	//������֣�Ӣ�������
				String s_fName = rs.getString(18);		//Ա������������
				String s_fRelation = rs.getString(19);	//Ա�������뱾�˹�ϵ�����ס�ĸ�ס���ż��
				boolean s_dismission = rs.getBoolean(20);	//�Ƿ���ְ
				String s_idNum = rs.getString(21);		//���֤��
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//ע�ⷵ��ֵ�в��ź͸�λֻ��id��������Ϣ��Ч��
	}
	
	@Override
	public ArrayList<Staff> queryDepartmentTransferStaffa(String departmentName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<Staff> st = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select S_ID,S_NAME,S_SEX,S_BIRTHDAY,S_DEPARTMENTID,S_JOBID"
				+ ",S_DATE,S_JSDATE,S_EINFORMATION,S_PSOURCE,S_TEL"
				+ ",S_EMAIL,S_EDUCATION,S_EXPERIENCE,S_ESDATE,S_EEDATE"
				+ ",S_FLANGUAGE,S_FNAME,S_FRELATION,S_DISMISSION,S_IDNUM"
				+ ",D_NAME,J_NAME"
				+ " from department_transfer dt,Staff s, department d,job j"
				+ " where dt.DT_STAFFID = s.S_ID AND dt.DT_DEPARTMENT = d.D_ID AND s.S_JOBID=j.J_ID"
				+ " AND d.D_NAME like ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+departmentName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int s_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				String s_name = rs.getString(2);	//����
				String s_sex = rs.getString(3);	//�Ա�1�У�2Ů��
				String s_birthday = rs.getString(4);	//��������				
				int d_id = rs.getInt(5);	//���źţ����
				int j_id = rs.getInt(6);	//��λ�ţ����
				 
				String s_date = rs.getString(7);		//��ְ����
				String s_jsDate = rs.getString(8);	//�μӹ�������
				String s_eInformation = rs.getString(9);	//�ù���ʽ����ʽԱ������ʱԱ����
				String s_pSource = rs.getString(10);	//��Ա��Դ��У԰��Ƹ�������Ƹ��������
				String s_Tel = rs.getString(11);		//��ϵ�绰
				
				String s_email = rs.getString(12); 	//�����ʼ�
				String s_education = rs.getString(13);	//���ѧ�������м����£���ר�����ƣ��о�����
				String s_exprience = rs.getString(14);	//ĳһ�׶δ��¹�����ѧϰ����
				String s_esDate = rs.getString(15);	//�ý׶ε���ʼ����
				String s_eeDate = rs.getString(16);	//�ý׶εĽ�ֹ����
				
				String s_fLanguage = rs.getString(17);	//������֣�Ӣ�������
				String s_fName = rs.getString(18);		//Ա������������
				String s_fRelation = rs.getString(19);	//Ա�������뱾�˹�ϵ�����ס�ĸ�ס���ż��
				boolean s_dismission = rs.getBoolean(20);	//�Ƿ���ְ
				String s_idNum = rs.getString(21);		//���֤��
				
				String d_name = rs.getString(22);
				String j_name = rs.getString(23);
				Department d = new Department();
				d.setD_id(d_id);
				d.setD_name(d_name);
				Job j = new Job();
				j.setJ_id(j_id);
				j.setJ_name(j_name);				
				
				Staff s = new Staff(s_id,s_name,s_sex,s_birthday,d,j
						,s_date,s_jsDate,s_eInformation,s_pSource,s_Tel
						,s_email,s_education,s_exprience,s_esDate,s_eeDate
						,s_fLanguage,s_fName,s_fRelation,s_dismission,s_idNum);
				st.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		
		return st;//ע�ⷵ��ֵ�в��ź͸�λֻ��id��������Ϣ��Ч��
	}
//	public static void main(String[] args) {//����insertDepartmentTransfer
//		Department db = new Department();//��תǰ�Ĳ���
//		Department da = new Department();
//		Staff s = new Staff();
//		db.setD_id(1);
//		da.setD_id(2);
//		s.setS_id(2);
//		DepartmentTransfer dt = new DepartmentTransfer(4,db,da,s,"��������","��ˮ��","2020-03-02");
//		
//		DepartmentManagementDao dmd = new DepartmentManagementDao();
//		dmd.deleteDepartmentTransfer(dt);
//	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByPreDepName(String preDepName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "dp.D_NAME LIKE ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+preDepName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByDepName(String DepName) {
		Connection conn = DBUtil.getConnection();
		ArrayList<DepartmentTransfer> ald = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(conn);
		String sql="select DT_ID,DT_PRE_DEPARTMENT,DT_DEPARTMENT,DT_STAFFID,DT_TYPE"
				+ ",DT_REASON,DT_DATE,dp.D_NAME,d.D_NAME,s.S_NAME"
				+ " from department_transfer dt,department dp,department d,staff s"
				+ " where dp.D_ID=dt.DT_PRE_DEPARTMENT AND d.D_ID=dt.DT_DEPARTMENT"
				+ " AND s.S_ID=dt.DT_STAFFID AND "
				+ "d.D_NAME LIKE ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+DepName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {			
				int dt_id = rs.getInt(1);	//Ա���ţ��������Զ�����
				int dt_preDepartment = rs.getInt(2);	//��תǰ�Ĳ��ţ����
				int dt_department = rs.getInt(3);	//��ת��Ĳ��ţ����
				int dt_staffId = rs.getInt(4);	//��תԱ�������
				String dt_type = rs.getString(5);	//��ת���ͣ������������������������ݴ���
				String dt_reason= rs.getString(6);	//��תԭ��
				String dt_date= rs.getString(7);	//��������
				String dpd_name= rs.getString(8);	
				String dd_name= rs.getString(9);	
				String ss_name= rs.getString(10);	
				
				Department dp = new Department();
				dp.setD_id(dt_preDepartment);
				Department d = new Department();
				d.setD_id(dt_department);
				Staff s = new Staff();
				s.setS_id(dt_staffId);
				
				dp.setD_name(dpd_name);
				d.setD_name(dd_name);
				s.setS_name(ss_name);
				
				DepartmentTransfer dt = new DepartmentTransfer(dt_id,dp,d,s,dt_type,dt_reason,dt_date);
				ald.add(dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return ald;
	}
	
//	public static void main(String[] args) {//����queryDepartmentTransferStaffb��queryDepartmentTransferStaffa
//		IDepartmentManagementDao dmd = new DepartmentManagementDao();
//		ArrayList<DepartmentTransfer> st = dmd.querydtByDepName("����");
//		for(DepartmentTransfer s:st) {
//			System.out.println(s.toString());
//		}
//	}
	
//	public static void main(String[] args) {
//		IDepartmentManagementDao dmd = new DepartmentManagementDao();
//		ArrayList<DepartmentTransfer> dts = dmd.querydtByDate("2020-01-01");
//		for(DepartmentTransfer dt:dts) {
//			System.out.println(dt.toString());			
//			System.out.println(dt.getDt_department().getD_name());
//			System.out.println(dt.getDt_staffID().getS_name());
//		}
//	}
}
