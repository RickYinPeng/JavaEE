package yp.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * Ŀ�ģ����˶����������ʱ�����������ִ�У�����
 * @author ����
 *
 */
public class MyInterceptor2 implements Interceptor {

	
	
	
	public MyInterceptor2() {
		System.out.println("1):������������2����");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		System.out.println("2):������������2��init����");
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("4):������������2��Action------ǰ��Ĵ���");
		
		//���У�������һ�������������û����һ������������ô����Ŀ���Action
		invocation.invoke();
		
		
		System.out.println("6):������������2��Action------����Ĵ���");
		return null;
	}
	
}
