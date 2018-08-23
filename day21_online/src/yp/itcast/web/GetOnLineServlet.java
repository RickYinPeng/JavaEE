package yp.itcast.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yp.itcast.entity.OnLineBean;

/**
 * 该Servlet用于将存储Map集合的登录用户的数据转换到List<OnLineBean>集合中去
 * 
 * @author 鹏鹏
 *
 */
public class GetOnLineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1:从context域中取出Map集合
		Map<String, HttpSession> onLine = (Map<String, HttpSession>) this.getServletContext().getAttribute("onLine");

		// 2:创建一个新的List集合
		List<OnLineBean> list = new ArrayList<OnLineBean>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("1#######");

		// 3:遍历Map集合
		if (onLine != null) {

			synchronized (this.getClass()) {

				for (Map.Entry<String, HttpSession> entry : onLine.entrySet()) {
					System.out.println("2#######");
					OnLineBean bean = new OnLineBean();

					bean.setSessionID(entry.getKey());
					HttpSession session = entry.getValue();
					bean.setName((String) session.getAttribute("user"));
					bean.setIp((String) session.getAttribute("ip"));
					bean.setLogin(sdf.format(new Date(session.getCreationTime())));
					bean.setLastTime(sdf.format(new Date(session.getLastAccessedTime())));
					list.add(bean);
				}
			} 
		}

		// 3):把list转发到jsp页面中
		request.setAttribute("list", list);
		request.getRequestDispatcher("/online.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
