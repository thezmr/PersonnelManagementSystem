package com.llz.renshi.move.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.renshi.move.domain.Base;
import com.llz.renshi.move.domain.Staff;
import com.llz.renshi.move.service.BaseService;
import com.llz.renshi.move.service.IBaseService;
import com.llz.renshi.move.service.IStaffService;
import com.llz.renshi.move.service.StaffService;

/**
 * Servlet implementation class StaffQueryFromBaseServlet
 */
@WebServlet("/StaffQueryFromBaseServlet")
public class StaffQueryFromBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffQueryFromBaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStaffService iss = new StaffService();
		ArrayList<Staff> staffs = iss.queryStaffByBase();//�����������˲ſ��е�Ա����Ϣ���ɲ������͸�λ����ע�ⲿ�Ÿ�λΪ����
		
		request.setAttribute("st", staffs);
		
		request.getRequestDispatcher("/pages/move/baseList.jsp").forward(request, response);
		
	}

}
