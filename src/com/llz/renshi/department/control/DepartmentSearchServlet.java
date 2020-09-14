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
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/DepartmentSearchServlet")
public class DepartmentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		IDepartmentService ds = new DepartmentService();
		String name = (String) request.getParameter("depname");
//		System.out.println(name);
		ArrayList<Department> deps = ds.queryDepartmentsByName(name);
		request.setAttribute("deps", deps);

		request.getRequestDispatcher("/pages/department/departmentSearchResult.jsp").forward(request, response);
		
	}

}
