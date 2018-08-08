package yp.itcast.c_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import yp.itcast.service.UserService;
import yp.itcast.service.UserServiceImpl;

//�۹����=>cglib����
public class UserServiceProxyFactory2 implements MethodInterceptor{
	

	public UserService getUserServiceProxy(){
		//���������ɴ������
		Enhancer en = new Enhancer();
		
		//���ö�˭���д���
		en.setSuperclass(UserServiceImpl.class);
		
		//���ô���Ҫ��ʲô
		en.setCallback(this);
		
		UserService us = (UserService) en.create();
	
		return us;
	}

	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//������
		System.out.println("������!!!");
		
		//����ԭ�з���
		Object returnvalue = methodProxy.invokeSuper(obj, arg);
		
		//�ύ����
		System.out.println("�ύ����!!!");
		return returnvalue;
	}
}
