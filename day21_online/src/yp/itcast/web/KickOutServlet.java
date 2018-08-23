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
		//1:接收剔除的id
		String sessionId = request.getParameter("sessionId");
		
		//2：强制注销指定id的用户
		Map<String,HttpSession> onLine  = (Map<String, HttpSession>) 
				this.getServletContext().getAttribute("onLine");
		
		//查询需要注销的session对象
		HttpSession Session = onLine.get(sessionId);
		if(Session!=null){
			Session.removeAttribute("user");//自动调用监听器，移除map中已经注销的用户信息
			Session.removeAttribute("ip");
		}
		
		response.sendRedirect(request.getContextPath()+"/GetOnLineServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
