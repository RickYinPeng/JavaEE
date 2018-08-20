package yp.itcast.d_session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession对象的监听器
 * @author 鹏鹏
 *
 */
public class MySessionListener implements HttpSessionListener{
	
	//用于存储当前访客人数
	private int count = 0;
	
	/**
	 * 用于监听HttpSession对象的创建
	 */
	/**
	 * 每次创建一个session对象，就代表一个在线访问进入网站
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("一个session对象已经被创建！！！"+se.getSession());
		
		ServletContext context = se.getSession().getServletContext();
		
		/**
		 * 使用代码同步避免因为多个用户同时访问引发的并发问题（导致count数量不对）
		 */
		synchronized (this.getClass()) {	//注意：锁对象必须是唯一的，类对象就是唯一的
			count++;
			
			//把count通过context域对象共享到jsp页面
			//可以通过session对象获取ServletContext对象的
			context.setAttribute("onLine", count);
		}
		
	}
	
	/**
	 * 当用户对应的session对象销毁了，代表访问离线了
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("一个session对象被销毁了！！！"+se.getSession());
		
		ServletContext context = se.getSession().getServletContext();
		synchronized (this.getClass()) {
			count--;
			
			//把count通过context域对象共享到jsp页面
			//可以通过session对象获取ServletContext对象的
			context.setAttribute("onLine", count);
		}
		
	}
}
