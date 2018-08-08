package yp.itcast.c_proxy;

import org.junit.Test;

import yp.itcast.service.UserService;
import yp.itcast.service.UserServiceImpl;

public class Demo {
	
	@Test
	//��̬����
	public void fun(){
		UserServiceImpl us = new UserServiceImpl();
		
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		
		UserService usProxy = factory.getUserServiceProxy();
	
		usProxy.save();
		
		//��������뱻�������ʵ������ͬ�Ľӿ�
		//��������뱻�������û�м̳й�ϵ
		System.out.println(usProxy instanceof UserServiceImpl);//false
	}
	
	@Test
	public void fun2(){
		
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		
		UserService usProxy = factory.getUserServiceProxy();
	
		usProxy.save();
		
		//�жϴ�������Ƿ����ڱ������������
		//�������̳��˱�����������Խ����true
		System.out.println(usProxy instanceof UserServiceImpl);//true
		
		
	}
	
}
