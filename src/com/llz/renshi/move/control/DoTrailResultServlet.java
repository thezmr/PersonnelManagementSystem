package com.llz.renshi.move.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Dismission;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.domain.StaffCheck;
import com.llz.renshi.move.domain.StaffTrail;
import com.llz.renshi.move.service.DismissionService;
import com.llz.renshi.move.service.IDismissionService;
import com.llz.renshi.move.service.IStaffCheckService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.IStaffTrailService;
import com.llz.renshi.move.service.StaffCheckService;
import com.llz.renshi.move.service.StaffService;
import com.llz.renshi.move.service.StaffTrailService;

/**
 * Servlet implementation class DoTrailResultServlet
 */
@WebServlet("/DoTrailResultServlet")
public class DoTrailResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTrailResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result = request.getParameter("result");//System.out.println(result);
		int s_id = Integer.parseInt(request.getParameter("sid"));
		//System.out.println(s_id);
		
		if (result.equals("pass")) {
			//Ա��ת���������ڿ��˱������ת����Ϣ��
			//System.out.println("ת��");
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//ͨ��Ա��id������ñ��¼
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"����","ת��","2020-01-01");//ͨ�����ñ����id��ӿ��˱�
			iscs.insertStaffCheck(sc1);	//�ڿ��˱������ת����Ϣ
		}
		else if (result == "delay") {
			//Ա���ӳٲ������ڿ��˱������ת����Ϣ��
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//ͨ��Ա��id������ñ��¼
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"����","����","2020-01-01");//ͨ�����ñ����id��ӿ��˱�
			iscs.insertStaffCheck(sc1);	//�ڿ��˱������ת����Ϣ
		}
		else if (result == "no_pass") {
			//Ա���ӳٲ������ڿ��˱������ת����Ϣ��
			IStaffTrailService ists = new StaffTrailService();
			IStaffCheckService iscs = new StaffCheckService();
			StaffTrail st = new StaffTrail();
			
			ArrayList<StaffTrail> alsc = ists.queryStaffTrailByStaffId(s_id);//ͨ��Ա��id������ñ��¼
			for(StaffTrail sst:alsc) {	
				st = sst;
			}
			StaffCheck sc1 = new StaffCheck(st,"���ϸ�","��ͨ��","2020-01-01");//ͨ�����ñ����id��ӿ��˱�
			iscs.insertStaffCheck(sc1);	//�ڿ��˱������ת����Ϣ
			Staff s = new Staff();		//Ա���������ְ��Ϣ
			s.setS_id(s_id);	//���Ա����Ų�����
			s.setS_dismission(true);//����ְ��Ϣ����Ϊ��
			IStaffService iss = new StaffService();
			iss.updateStaffDismissionById(s);//��Ա����Ϣ����ְ��Ϣ����	
			
			IDismissionService ids = new DismissionService();//����ְ���������ְ��Ϣ
			Dismission dismission = new Dismission(s,"2099-12-31","������δͨ��",false);
			ids.insertDismission(dismission);
		}
		
		response.sendRedirect("/code/pages/transfer/jumpToSearchTrailServlet.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
