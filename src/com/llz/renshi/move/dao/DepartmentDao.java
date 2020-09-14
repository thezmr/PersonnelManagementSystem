package com.llz.renshi.move.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.llz.renshi.department.dao.DBUtil;
import com.llz.renshi.move.domain.Department;

public class DepartmentDao implements IDepartmentDao {
	@Override
	public Department queryIdDepartmentsByName(String name) {
		Connection conn = DBUtil.getConnection();
		String sql = "select D_ID from department where d_name=?";
		PreparedStatement ps = null;
		ResultSet rs  = null;
		Department d =new Department();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {							
				int d_id = rs.getInt(1);
				
				d.setD_id(d_id);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.close(ps, conn);
		}
		return d;	
	}
	
//	public static void main(String [] args) {
//		IDepartmentDao idd =new DepartmentDao();
//		Department ds = idd.queryIdDepartmentsByName("���۲���");
//		System.out.print(ds.getD_id());
//	}
}
