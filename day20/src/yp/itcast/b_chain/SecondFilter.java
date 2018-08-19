package yp.itcast.b_chain;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 第二个过滤器
 * @author 鹏鹏
 *
 */
public class SecondFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * 执行过滤任务
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("2):执行第二个过滤器的请求过滤");
		
		chain.doFilter(request, response);
		
		System.out.println("4):执行第二个过滤器的---响应过滤");
		
		
	}



}
