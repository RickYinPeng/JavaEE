package yp.itcast.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.bean.User;

public class Demo {
	
	@Test
	//创建方式1：空参构造
	public void fun(){
		
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user");
		
		//3：打印User对象
		System.out.println(u);
		
	}
	
	@Test
	//创建方式2：静态工厂
	public void fun2(){
		
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user2");
		//3：打印User对象
		System.out.println(u);
		
	}
	
	@Test
	//创建方式3：实例工厂
	public void fun3(){
		
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user3");
		//3：打印User对象
		System.out.println(u);
		
	}
	
	@Test
	//scope:singleton（默认值）：单例对象，被标识为单例的对象在spring容器中只会存在一个实例
	//prototype：多例原型，被标识为多例的对象，每次再获得才会创建（单例会在使用容器时创建），每次创建都是新的
	public void fun4(){
		
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user");
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		User u3 = (User) ac.getBean("user");
		
		System.out.println(u==u3);//单例：true	多例：false
		//3：打印User对象
		System.out.println(u);
		
	}
	
	@Test
	//测试生命周期方法
	public void fun5(){
		
		//1：创建容器对象（src下找）
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2：向容器"要"User对象
		User u = (User) ac.getBean("user");
		
		//3：打印User对象
		System.out.println(u);
		
		//关闭容器，触发销毁方法
		ac.close();
		
	}
}
