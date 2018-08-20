package yp.itcast.b_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext的监听器
 * @author 鹏鹏
 *需求：
 *	1）：在项目启动的时候，初始化表
 *	2）：在项目结束的时候，删除表
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener{
	
	/**
	 * 改方法监听ServletContext对象的创建行为
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context对象创建");
	}
	
	/**
	 * 该方法监听ServletContext对象的销毁
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context对象被销毁");
	}
	
	/*************************** 属性相关的 *************************************/
	/**
	 * 属性增加
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("属性增加");
		//得到属性名
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("属性增加："+name+" = "+value);
		
	}
	
	/**
	 * 属性删除
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("属性删除");
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("属性删除："+name+" = "+value);
	}
	/**
	 * 属性修改
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("属性修改");
		String name = scab.getName();
		
		//得到的时修改前的属性值
		//Object value = scab.getValue();
		
		//得到修改后的属性值
		//需要从servletContext事件源对象再次获取属性，才可以得到最新的属性值。
		ServletContext servletContext = scab.getServletContext();
		Object value = servletContext.getAttribute(name);
		
		System.out.println("属性修改："+name+" = "+value);
	}
	
	
	
}
