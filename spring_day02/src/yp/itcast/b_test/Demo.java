package yp.itcast.b_test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yp.itcast.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)//�����Ǵ�������
//ָ����������ʱʹ���ĸ������ļ�
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	
	//����Ϊuser�Ķ���ע�뵽u������
	@Resource(name="user")
	private User u;
	
	@Test
	public void fun(){
		System.out.println(u);
		
		
	}
}
