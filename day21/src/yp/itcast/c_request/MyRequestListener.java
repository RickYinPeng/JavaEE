package yp.itcast.c_request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * ServletRequest的监听器
 * @author 鹏鹏
 *
 */
public class MyRequestListener implements ServletRequestListener,ServletRequestAttributeListener{
	
	
	/**
	 * 监听request对象的创建
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("一个请求被创建！！！");
	
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		//得到客户的IP地址
		String ip = request.getRemoteHost();
		
		//共享数据到页面
		//HttpSession session = request.getSession();
		//session.setAttribute("ip", ip);
		
		//System.out.println("ip:"+ip);
	}
	
	/**
	 * 用于监听request对象的销毁
	 * 
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("一个对象被销毁！！！");
		
	}
	
	
	/*********************属性相关*****************************/
	
	
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("属性增加："+name+"="+value);
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		
		ServletRequest request = srae.getServletRequest();
		Object value = request.getAttribute(name);
		System.out.println("属性修改："+name+"="+value);
	}	
	
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("属性删除："+name+"="+value);
	}





}
