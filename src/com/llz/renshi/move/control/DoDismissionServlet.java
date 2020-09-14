package com.llz.renshi.move.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Base;
import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.Dismission;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.BaseService;
import com.llz.renshi.move.service.DismissionService;
import com.llz.renshi.move.service.IBaseService;
import com.llz.renshi.move.service.IDismissionService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.StaffService;

/**
 * Servlet implementation class DoDismissionServlet
 */
@WebServlet("/DoDismissionServlet")
public class DoDismissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDismissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sid = request.getParameter("sid");
		//System.out.println(sid);
		String type = request.getParameter("type");
		//System.out.println(type);
		String result = request.getParameter("result");
		//System.out.println(result);		
		boolean pool = Boolean.parseBoolean(result);
		String date = request.getParameter("date");
		
		//��ְ����
		//Ա����Ϣ�������ְ������ְ���������Ϣ���������˲ſ����˲ſ���������Ϣ
		IStaffService iss = new StaffService();
		Staff staff = new Staff();
		staff.setS_id(Integer.parseInt(sid));
		staff.setS_dismission(true);//������ְΪ��
		iss.updateStaffDismissionById(staff);//����Ա������ְ���ֻҪid���Ժ���ְ����				
		IDismissionService ids = new DismissionService();
		Dismission dis = new Dismission(staff,date,type,pool);
		ids.insertDismission(dis);//����ְ���������Ϣ��
				
		if(pool == true) {
			//���˲ſ��в����¼
			Base base = new Base(staff);
			IBaseService ibs = new BaseService();
			ibs.insertBase(base);
		}
		
		response.sendRedirect("/code/pages/transfer/jumpToDismission2.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
