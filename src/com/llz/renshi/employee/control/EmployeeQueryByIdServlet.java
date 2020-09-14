package com.llz.renshi.employee.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.employee.domain.Department;
import com.llz.renshi.employee.domain.Employee;
import com.llz.renshi.employee.domain.Job;
import com.llz.renshi.employee.service.DepartmentService;
import com.llz.renshi.employee.service.EmployeeService;
import com.llz.renshi.employee.service.IDepartmentService;
import com.llz.renshi.employee.service.IEmployeeService;
import com.llz.renshi.employee.service.IJobService;
import com.llz.renshi.employee.service.JobService;


/**
 * Servlet implementation class EmployeeQueryByIdServlet
 */
@WebServlet("/EmployeeQueryByIdServlet")
public class EmployeeQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeQueryByIdServlet() {
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
		String id = request.getParameter("eid");
		int eid = Integer.parseInt(id);
		IEmployeeService ps = new EmployeeService();
		Employee p =ps.queryEmployeeByID(eid);
		
		IDepartmentService dns = new DepartmentService();
		ArrayList<Department> dname = dns.queryDepartment();
		
		IJobService jns = new JobService();
		ArrayList<Job> jname = jns.queryJob();
		
		request.setAttribute("departmentname", dname);
		request.setAttribute("jobname", jname);
		request.setAttribute("employee", p);
		request.getRequestDispatcher("/pages/staff/staffUpdate.jsp").forward(request, response);
	}

}
