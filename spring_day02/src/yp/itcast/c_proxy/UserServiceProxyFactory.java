package yp.itcast.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import yp.itcast.service.UserService;
import yp.itcast.service.UserServiceImpl;

//�۹����=>��̬����
public class UserServiceProxyFactory implements InvocationHandler{
	
	private UserService us;

	public UserServiceProxyFactory(UserService us) {
		super();
		this.us = us;
	}

	public UserService getUserServiceProxy(){
		//���ɶ�̬������
		UserService usProxy = (UserService) Proxy.newProxyInstance(
				UserServiceProxyFactory.class.getClassLoader(), 
				UserServiceImpl.class.getInterfaces(),
				this
				);
		//����
		return usProxy;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("�����񣡣���");
		
		System.out.println("proxy:"+proxy.getClass().getName());
		System.out.println("method:"+method.getName());
		Object invoke = method.invoke(us, args);
		
		System.out.println("�ر����񣡣���");
		
		return invoke;
	}
}
