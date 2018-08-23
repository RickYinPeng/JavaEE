package yp.itcast.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1:�����޳���id
		String sessionId = request.getParameter("sessionId");
		
		//2��ǿ��ע��ָ��id���û�
		Map<String,HttpSession> onLine  = (Map<String, HttpSession>) 
				this.getServletContext().getAttribute("onLine");
		
		//��ѯ��Ҫע����session����
		HttpSession Session = onLine.get(sessionId);
		if(Session!=null){
			Session.removeAttribute("user");//�Զ����ü��������Ƴ�map���Ѿ�ע�����û���Ϣ
			Session.removeAttribute("ip");
		}
		
		response.sendRedirect(request.getContextPath()+"/GetOnLineServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
