package yp.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1�����ղ���
		String userName = request.getParameter("userName");
		
		//2:��¼�ɹ�
		//�������ݵ�session�������
		HttpSession session = request.getSession(true);
		
		
		/**
		 * ��дһ��HttpSession�����Լ����������ڼ���user�������Ƶ�����
		 */
		session.setAttribute("user", userName);
		//�ѵ�¼�û���IP��ַ��ŵ�session��
		session.setAttribute("ip", request.getRemoteHost());
		
		//3:��ת���û���ҳ
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
