package com.llz.renshi.job.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.job.domain.Job;
import com.llz.renshi.job.service.IJobService;
import com.llz.renshi.job.service.JobService;



/**
 * Servlet implementation class jobSearchServlet
 */
@WebServlet("/JobSearchServlet")
public class JobSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobSearchServlet() {
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
		IJobService js = new JobService();
		String name = (String) request.getParameter("jobname");
//		System.out.println(name);
		ArrayList<Job> jobs = js.queryJobsByName(name);
		request.setAttribute("jobs", jobs);


		request.getRequestDispatcher("/pages/job/jobSearchResult.jsp").forward(request, response);
		
	}

}
