package yp.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * Ŀ�ģ��鿴����������������
 * @author ����
 *
 */
public class MyInterceptor1 implements Interceptor {

	
	
	
	public MyInterceptor1() {
		System.out.println("1):������������1����");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		System.out.println("2):������������1��init����");
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("4):������������1��Action------ǰ��Ĵ���");
		
		//���У�������һ�������������û����һ������������ô����Ŀ���Action
		invocation.invoke();
		
		System.out.println("6):������������1��Action------����Ĵ���");
		return null;
	}
	
}
