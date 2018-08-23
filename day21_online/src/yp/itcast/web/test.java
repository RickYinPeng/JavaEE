package yp.itcast.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class test extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<HttpSession> list = new ArrayList<HttpSession>();
		
		session.setAttribute("list", 123);
		
		list.add(session);
		
		session.setAttribute("name", "ÕÅÈý");
		
		for (HttpSession s : list) {
			Object attribute = s.getAttribute("name");
			System.out.println(attribute);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
