package yp.itcast.d_cases;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetParamServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * ��ҵ���servlet����request��getParameter����֮ǰ��
		 * 		��дgetParameter��������д֮���ȡ�Ĳ������Ǿ�����ȷ��ת������ݡ�
		 */

		String userName = request.getParameter("userName");
		
		System.out.println(userName);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
