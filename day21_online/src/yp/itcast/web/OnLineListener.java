package yp.itcast.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnLineListener implements HttpSessionAttributeListener {

	// private Map<String,HttpSession> onLine = new HashMap<String,
	// HttpSession>();

	/**
	 * ���û���¼�ɹ����ִ��Add���� �÷������ڼ����û���user���Ե����
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		// �õ�������
		String name = se.getName();
		System.out.println("name:"+name);
		
		ServletContext context = se.getSession().getServletContext();
		if ("user".equals(name)) {
			System.out.println("user");
			
			synchronized (this.getClass()) {
				
				// 1:�ѵ�ǰ��¼��session�����װ��Map������

				// 1.1 �ȴ�context���л�ȡsession����
				Map<String, HttpSession> onLine = (Map<String, HttpSession>) context.getAttribute("onLine");

				// 1.2 �������վ�ĵ�һ����¼�û�����ʱonLineΪnull����ʱ�½�һ��Map����
				if (onLine == null) {
					onLine = new HashMap<String, HttpSession>();
				}

				// 1.3 �ѵ�ǰ�û���session����Map����
				HttpSession session = se.getSession();
				onLine.put(session.getId(), session);
				

				// 2:�ѷ�װ�õ�map���浽context����
				context.setAttribute("onLine", onLine);

			}
		}
		System.out.println("@@@@");
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		String name = se.getName();
		String id = se.getSession().getId();
		ServletContext context = se.getSession().getServletContext();
		if("user".equals(name)){
			//1:��ȡcontext���е�map����
			Map<String,HttpSession> onLine = (Map<String, HttpSession>) 
					context.getAttribute("onLine");
			
			//2��ɾ����Ӧ��session����
			onLine.remove(id);
			
			//3�����޸ĺ��map���浽context��
			context.setAttribute("onLine", onLine);
		}
		
		

	
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

}
