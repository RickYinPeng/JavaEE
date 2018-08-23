package yp.itcast.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnLineListener implements HttpSessionAttributeListener {

	// private Map<String,HttpSession> onLine = new HashMap<String,
	// HttpSession>();

	/**
	 * 当用户登录成功后会执行Add代码 该方法用于监听用户的user属性的添加
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 得到属性名
		String name = se.getName();
		System.out.println("name:"+name);
		
		ServletContext context = se.getSession().getServletContext();
		if ("user".equals(name)) {
			System.out.println("user");
			
			synchronized (this.getClass()) {
				
				// 1:把当前登录的session对象封装到Map集合中

				// 1.1 先从context域中获取session数据
				Map<String, HttpSession> onLine = (Map<String, HttpSession>) context.getAttribute("onLine");

				// 1.2 如果是网站的第一个登录用户，这时onLine为null，这时新建一个Map集合
				if (onLine == null) {
					onLine = new HashMap<String, HttpSession>();
				}

				// 1.3 把当前用户的session存入Map集合
				HttpSession session = se.getSession();
				onLine.put(session.getId(), session);
				

				// 2:把封装好的map保存到context域中
				context.setAttribute("onLine", onLine);

			}
		}
		System.out.println("@@@@");
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		String name = se.getName();
		String id = se.getSession().getId();
		ServletContext context = se.getSession().getServletContext();
		if("user".equals(name)){
			//1:获取context域中的map集合
			Map<String,HttpSession> onLine = (Map<String, HttpSession>) 
					context.getAttribute("onLine");
			
			//2：删除对应的session对象
			onLine.remove(id);
			
			//3：把修改后的map保存到context中
			context.setAttribute("onLine", onLine);
		}
		
		

	
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
