package yp.itcast.b_chain;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * �ڶ���������
 * @author ����
 *
 */
public class SecondFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * ִ�й�������
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("2):ִ�еڶ������������������");
		
		chain.doFilter(request, response);
		
		System.out.println("4):ִ�еڶ�����������---��Ӧ����");
		
		
	}



}
