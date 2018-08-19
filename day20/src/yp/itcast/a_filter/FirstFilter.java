package yp.itcast.a_filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{

	
	public FirstFilter() {
		System.out.println("1):过滤器对象创建了！！！");
	}
	
	/**
	 * FilterConfig对象封装了所有当前过滤器配置的初始化参数
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2):过滤器初始化方法");
		
		/**
		 * 获取初始化参数
		 */
		String AAA = filterConfig.getInitParameter("AAA");
		System.out.println(AAA);
		//遍历所有的参数
		Enumeration<String> enmus = filterConfig.getInitParameterNames();
		while(enmus.hasMoreElements()){
			String paramName = enmus.nextElement();
			String value = filterConfig.getInitParameter(paramName);
			System.out.println(value);
		}
		
	}

	/**
	 * 执行过滤任务
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3):过滤器正在执行过滤任务！！！");
		
		//放行
		chain.doFilter(request, response);
		
		//
		System.out.println("5):过滤器正在执行过滤任务--过滤响应");
		
	}
	
	/**
	 * 过滤器对象销毁的时候才会调用
	 * 	web项目重新部署或者tomcat服务器停止了才会销毁过滤器对象
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器被销毁了");
	}




	
}
