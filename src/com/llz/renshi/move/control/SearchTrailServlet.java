package com.llz.renshi.move.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.StaffService;

/**
 * Servlet implementation class SearchTrailServlet
 */
@WebServlet("/SearchTrailServlet")
public class SearchTrailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTrailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ѯ������Ա���б�Ȳ���
		request.setCharacterEncoding("utf-8");
		String d_name = request.getParameter("dname");
		if (d_name == null) d_name = "";
		IStaffService iss = new StaffService();
		Department dep = new Department();
		dep.setD_name(d_name);
		ArrayList<Staff> staffs = iss.queryStaffTrailByDepartment(dep);//ͨ���������Ʋ����� ��Ա��
		request.setAttribute("st",staffs);
		request.getRequestDispatcher("pages/move/trailList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
