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
 * Servlet implementation class DepartmentDeleteServlet
 */
@WebServlet("/DepartmentDeleteServlet")
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentDeleteServlet() {
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
		
		
		IDepartmentService ds = new DepartmentService();
		ArrayList<Department> deps = ds.queryDepartments();
		request.setAttribute("deps", deps);

		request.getRequestDispatcher("/pages/department/departmentDelete.jsp").forward(request, response);
		
	}

}
