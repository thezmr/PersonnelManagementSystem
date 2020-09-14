package com.llz.renshi.move.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Job;
import com.llz.renshi.move.domain.JobTransfer;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.IJobManagementService;
import com.llz.renshi.move.service.IJobService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.JobManagementService;
import com.llz.renshi.move.service.JobService;
import com.llz.renshi.move.service.StaffService;



/**
 * Servlet implementation class JobTransServlet
 */
@WebServlet("/JobTransServlet")
public class JobTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobTransServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");		
		IStaffService isss =new StaffService();
		int s_id = Integer.parseInt(request.getParameter("sid"));//System.out.println(s_id);
		String preName = request.getParameter("prename");//System.out.println(preName);
		String name = request.getParameter("jname");//System.out.println(name);
		IJobManagementService ijms = new JobManagementService();

		IJobService ijs = new JobService();//��õ�ת��λid
		Job job1 = ijs.queryIdJobsByName(preName);//ͨ����λ���Ƶ�תǰ����id
		Job job2 = ijs.queryIdJobsByName(name);//ͨ����λ���Ƶ�ת����id

		Staff s = new Staff();
		s.setS_id(s_id);		//Ա��id
		String type = "��ְ"; //��ְ����ְ������¼����� ��������
		JobTransfer jt = new JobTransfer(job1,job2,s,type,"2020-02-02");
		ijms.insertJobTransfer(jt);
		
		//����Ա���ĸ�λ��Ϣ
		s.setS_jobId(job2);
		isss.updateStaffJobById(s);
		
		response.sendRedirect("pages/transfer/jumpToStaffListServlet.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
