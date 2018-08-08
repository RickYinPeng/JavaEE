package yp.itcast.c_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.bean.User;

public class Demo {
	
	@Test
	public void fun(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/c_injection/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user");
		
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	public void fun2(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/c_injection/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user2");
		
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	public void fun3(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/c_injection/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user3");
		
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	public void fun4(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/c_injection/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user4");
		
		//3����ӡUser����
		System.out.println(u);
		
	}
	@Test
	public void fun5(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/c_injection/applicationContext.xml");
		//2��������"Ҫ"User����
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		
		//3����ӡUser����
		System.out.println(cb);
		
	}
}
