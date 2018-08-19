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
		System.out.println("1):���������󴴽��ˣ�����");
	}
	
	/**
	 * FilterConfig�����װ�����е�ǰ���������õĳ�ʼ������
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2):��������ʼ������");
		
		/**
		 * ��ȡ��ʼ������
		 */
		String AAA = filterConfig.getInitParameter("AAA");
		System.out.println(AAA);
		//�������еĲ���
		Enumeration<String> enmus = filterConfig.getInitParameterNames();
		while(enmus.hasMoreElements()){
			String paramName = enmus.nextElement();
			String value = filterConfig.getInitParameter(paramName);
			System.out.println(value);
		}
		
	}

	/**
	 * ִ�й�������
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3):����������ִ�й������񣡣���");
		
		//����
		chain.doFilter(request, response);
		
		//
		System.out.println("5):����������ִ�й�������--������Ӧ");
		
	}
	
	/**
	 * �������������ٵ�ʱ��Ż����
	 * 	web��Ŀ���²������tomcat������ֹͣ�˲Ż����ٹ���������
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("��������������");
	}




	
}
