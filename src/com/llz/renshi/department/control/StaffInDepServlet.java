package com.llz.renshi.department.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.department.domain.Department;
import com.llz.renshi.department.domain.Staff;
import com.llz.renshi.department.service.DepartmentService;
import com.llz.renshi.department.service.IDepartmentService;

/**
 * Servlet implementation class StaffInDepServlet
 */
@WebServlet("/StaffInDepServlet")
public class StaffInDepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffInDepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		IDepartmentService ds = new DepartmentService();
		ArrayList<Staff> st = ds.queryStaffsInDep(name);
		request.setAttribute("st", st);
		request.getRequestDispatcher("/pages/department/staffList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
