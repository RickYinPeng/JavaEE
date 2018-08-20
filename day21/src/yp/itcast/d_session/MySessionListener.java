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
 * HttpSession����ļ�����
 * @author ����
 *
 */
public class MySessionListener implements HttpSessionListener{
	
	//���ڴ洢��ǰ�ÿ�����
	private int count = 0;
	
	/**
	 * ���ڼ���HttpSession����Ĵ���
	 */
	/**
	 * ÿ�δ���һ��session���󣬾ʹ���һ�����߷��ʽ�����վ
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("һ��session�����Ѿ�������������"+se.getSession());
		
		ServletContext context = se.getSession().getServletContext();
		
		/**
		 * ʹ�ô���ͬ��������Ϊ����û�ͬʱ���������Ĳ������⣨����count�������ԣ�
		 */
		synchronized (this.getClass()) {	//ע�⣺�����������Ψһ�ģ���������Ψһ��
			count++;
			
			//��countͨ��context�������jspҳ��
			//����ͨ��session�����ȡServletContext�����
			context.setAttribute("onLine", count);
		}
		
	}
	
	/**
	 * ���û���Ӧ��session���������ˣ��������������
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("һ��session���������ˣ�����"+se.getSession());
		
		ServletContext context = se.getSession().getServletContext();
		synchronized (this.getClass()) {
			count--;
			
			//��countͨ��context�������jspҳ��
			//����ͨ��session�����ȡServletContext�����
			context.setAttribute("onLine", count);
		}
		
	}
}
