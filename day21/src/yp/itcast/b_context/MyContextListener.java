package yp.itcast.b_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext�ļ�����
 * @author ����
 *����
 *	1��������Ŀ������ʱ�򣬳�ʼ����
 *	2��������Ŀ������ʱ��ɾ����
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener{
	
	/**
	 * �ķ�������ServletContext����Ĵ�����Ϊ
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context���󴴽�");
	}
	
	/**
	 * �÷�������ServletContext���������
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context��������");
	}
	
	/*************************** ������ص� *************************************/
	/**
	 * ��������
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("��������");
		//�õ�������
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("�������ӣ�"+name+" = "+value);
		
	}
	
	/**
	 * ����ɾ��
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("����ɾ��");
		String name = scab.getName();
		Object value = scab.getValue();
		System.out.println("����ɾ����"+name+" = "+value);
	}
	/**
	 * �����޸�
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("�����޸�");
		String name = scab.getName();
		
		//�õ���ʱ�޸�ǰ������ֵ
		//Object value = scab.getValue();
		
		//�õ��޸ĺ������ֵ
		//��Ҫ��servletContext�¼�Դ�����ٴλ�ȡ���ԣ��ſ��Եõ����µ�����ֵ��
		ServletContext servletContext = scab.getServletContext();
		Object value = servletContext.getAttribute(name);
		
		System.out.println("�����޸ģ�"+name+" = "+value);
	}
	
	
	
}
