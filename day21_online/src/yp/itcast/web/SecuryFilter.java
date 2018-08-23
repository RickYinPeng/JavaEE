package yp.itcast.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecuryFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");		
		//1:管理员
		String ip = request.getRemoteHost();
		if("localhost".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
			//1:管理员
			chain.doFilter(request, response);
		}else{
			//2:非管理员
			response.getWriter().write("不要妄想了！！！");
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
