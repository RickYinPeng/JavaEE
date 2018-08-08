package yp.itcast.b_create;

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
	
	@Test
	//������ʽ2����̬����
	public void fun2(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user2");
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	//������ʽ3��ʵ������
	public void fun3(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user3");
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	//scope:singleton��Ĭ��ֵ�����������󣬱���ʶΪ�����Ķ�����spring������ֻ�����һ��ʵ��
	//prototype������ԭ�ͣ�����ʶΪ�����Ķ���ÿ���ٻ�òŻᴴ������������ʹ������ʱ��������ÿ�δ��������µ�
	public void fun4(){
		
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user");
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		User u3 = (User) ac.getBean("user");
		
		System.out.println(u==u3);//������true	������false
		//3����ӡUser����
		System.out.println(u);
		
	}
	
	@Test
	//�����������ڷ���
	public void fun5(){
		
		//1��������������src���ң�
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("yp/itcast/b_create/applicationContext.xml");
		//2��������"Ҫ"User����
		User u = (User) ac.getBean("user");
		
		//3����ӡUser����
		System.out.println(u);
		
		//�ر��������������ٷ���
		ac.close();
		
	}
}
