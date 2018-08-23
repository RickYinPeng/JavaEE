package yp.itcast.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

import yp.itcast.entity.User;
/**
 * Ŀ�꣺�����û���Ȩ��
 * @author ����
 *
 */
public class UserLoginInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	//ǰ�᣺�������е����󶼱��������������
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("����������");
		/**
		 * ���⣺������������Ҫ���� ��¼��user_login����ע������(user_register)
		 */
		//�õ���ǰ���ص�Ŀ��Action�������
		ActionProxy actionProxy = invocation.getProxy();
		
		//�õ���ǰִ�е�action�ķ���
		String methodName = actionProxy.getMethod();// login/register
		
		if("login".equals(methodName) || "register".equals(methodName)){
			//����
			System.out.println("��¼ע�������");
			return invocation.invoke();
		}
		
		//1):��ȡsession���е�����
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		User user = (User)session.get("user");
		
		//2):�ж�session���е������Ƿ����
		if(user==null){
			//3):��������ڣ�����ת����¼
			System.out.println("����δ��¼�����ȵ�¼");
			return "login";
		}else{
			//4):������ڣ������
			System.out.println("�����Ѿ���¼������");
			return invocation.invoke();
		}
	}
	
}
