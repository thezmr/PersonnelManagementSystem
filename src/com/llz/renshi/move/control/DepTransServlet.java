package com.llz.renshi.move.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Department;
import com.llz.renshi.move.domain.DepartmentTransfer;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.DepartmentManagementService;
import com.llz.renshi.move.service.DepartmentService;
import com.llz.renshi.move.service.IDepartmentManagementService;
import com.llz.renshi.move.service.IDepartmentService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.StaffService;

/**
 * Servlet implementation class DepTransServlet
 */
@WebServlet("/DepTransServlet")
public class DepTransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepTransServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		IStaffService isss =new StaffService();
		int s_id = Integer.parseInt(request.getParameter("sid"));System.out.println(s_id);
		String preName = request.getParameter("prename");System.out.println(preName);
		String name = request.getParameter("name");System.out.println(name);

		//���벿�ŵ�����Ϣ
		IDepartmentManagementService idms = new DepartmentManagementService();
		
		//��õ�ת����id
		IDepartmentService ids = new DepartmentService();
		Department dep1 = ids.queryIdDepartmentsByName(preName);//ͨ���������Ƶ�תǰ����id
		Department dep2 = ids.queryIdDepartmentsByName(name);//ͨ���������Ƶ�ת����id

		Staff s = new Staff();
		s.setS_id(s_id);		//Ա��id
		String type = "��������";//�����������������������ݴ��� ��������
		DepartmentTransfer dt = new DepartmentTransfer(dep1,dep2,s,type,"��","2020-02-02");
		idms.insertDepartmentTransfer(dt);
		
		//����Ա���Ĳ�����Ϣ
		s.setS_departmentId(dep2);
		isss.updateStaffDepartmentById(s);
		response.sendRedirect("pages/move/jumpToStaffListServletForDep.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
