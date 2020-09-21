package com.llz.renshi.job.control;

import java.io.IOException;
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
 * Servlet implementation class JobUpdateServlet
 */
@WebServlet("/JobUpdateServlet")
public class JobUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IJobService js = new JobService();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String ZHtype = null;
		switch(type) {
		case "manage":
			ZHtype = "管理";
			break;
		case "tech":
			ZHtype = "技术";
			break;
		case "mark":
			ZHtype = "市场";
			break;
		case "sell":
			ZHtype = "销售";
			break;
		}
		
		int size = Integer.parseInt(request.getParameter("size"));

		Job j = new Job(id,name,ZHtype,size);
		js.updateJob(j);
		request.getRequestDispatcher("/pages/job/jobList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
