package com.llz.renshi.move.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.DepartmentTransfer;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.DepartmentManagementService;
import com.llz.renshi.move.service.IDepartmentManagementService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.StaffService;

/**
 * Servlet implementation class StaffListServletForDep
 */
@WebServlet("/StaffListForDepServlet")
public class StaffListForDepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffListForDepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStaffService iss =new StaffService();
		Department dep = new Department();
		dep.setD_name("");
		ArrayList<Staff> st = iss.queryStaffByDepartment(dep);
		request.setAttribute("st", st);
		
		IDepartmentManagementService idms = new DepartmentManagementService();
		ArrayList<DepartmentTransfer> dt =  idms.querydtByPreDepName("");
		request.setAttribute("dt", dt);
		
		
		request.getRequestDispatcher("/pages/move/departmentTransferPages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
