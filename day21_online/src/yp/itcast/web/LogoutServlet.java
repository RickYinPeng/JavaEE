package yp.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 注销逻辑
 * @author 鹏鹏
 *
 */
public class LogoutServlet extends HttpServlet {
				
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 用户注销：删除在登录成功时保存在session域对象中的数据
		 */
		HttpSession session = request.getSession();
		if(session!=null){
			session.removeAttribute("user");
			session.removeAttribute("ip");
		}
		

		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
