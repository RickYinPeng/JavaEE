package yp.itcast.a_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.bean.User;

public class Demo {
	
	@Test
	//创建方式1：空参构造
	public void fun(){
		
		//1：创建容器对象（src下找）
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user");
		//User u2 = (User) ac.getBean("user");
		
		//System.out.println(u==u2);
		//3：打印User对象
		System.out.println(u);
		
		ac.close();
	}
}
