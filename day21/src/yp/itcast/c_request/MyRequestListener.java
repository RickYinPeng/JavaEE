package yp.itcast.c_request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * ServletRequest�ļ�����
 * @author ����
 *
 */
public class MyRequestListener implements ServletRequestListener,ServletRequestAttributeListener{
	
	
	/**
	 * ����request����Ĵ���
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("һ�����󱻴���������");
	
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		//�õ��ͻ���IP��ַ
		String ip = request.getRemoteHost();
		
		//�������ݵ�ҳ��
		//HttpSession session = request.getSession();
		//session.setAttribute("ip", ip);
		
		//System.out.println("ip:"+ip);
	}
	
	/**
	 * ���ڼ���request���������
	 * 
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("һ���������٣�����");
		
	}
	
	
	/*********************�������*****************************/
	
	
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("�������ӣ�"+name+"="+value);
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		
		ServletRequest request = srae.getServletRequest();
		Object value = request.getAttribute(name);
		System.out.println("�����޸ģ�"+name+"="+value);
	}	
	
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("����ɾ����"+name+"="+value);
	}





}
