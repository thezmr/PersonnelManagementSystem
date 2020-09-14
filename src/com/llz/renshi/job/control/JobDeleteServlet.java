package com.llz.renshi.job.control;

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
import com.llz.renshi.job.domain.Job;
import com.llz.renshi.job.service.IJobService;
import com.llz.renshi.job.service.JobService;

/**
 * Servlet implementation class JobDeleteServlet
 */
@WebServlet("/JobDeleteServlet")
public class JobDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDeleteServlet() {
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
		IJobService js = new JobService();
		ArrayList<Job> jobs = js.queryJobs();
		request.setAttribute("jobs", jobs);
	
		request.getRequestDispatcher("/pages/job/jobMaintain.jsp").forward(request, response);
	}

}
