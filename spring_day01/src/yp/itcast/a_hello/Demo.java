package yp.itcast.a_hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.bean.User;

public class Demo {
	
	@Test
	//������ʽ1���ղι���
	public void fun(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user");
		//3����ӡUser����
		System.out.println(u);
		
	}
}
