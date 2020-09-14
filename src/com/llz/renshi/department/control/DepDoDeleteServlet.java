package com.llz.renshi.department.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.department.domain.Department;
import com.llz.renshi.department.service.DepartmentService;
import com.llz.renshi.department.service.IDepartmentService;

/**
 * Servlet implementation class DoDeleteServlet
 */
@WebServlet("/DepDoDeleteServlet")
public class DepDoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepDoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		IDepartmentService ds = new DepartmentService();
		String name = request.getParameter("dname");
		String type = request.getParameter("dtype");
		String ZHtype;
		if (type == "dep") {
			ZHtype = "����";
		}
		else ZHtype = "��˾";
		
		String tel = request.getParameter("dtel");
		String date = request.getParameter("ddate");
		
		if (date == "")
		{
			date = "1970-01-01";
		}
		Department d = new Department(name,ZHtype,tel,date);
		ds.deleteDepartmentByName(d);
		request.getRequestDispatcher("/pages/department/departmentList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
