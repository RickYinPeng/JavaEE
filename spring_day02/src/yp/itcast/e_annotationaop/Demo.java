package yp.itcast.e_annotationaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yp.itcast.bean.User;
import yp.itcast.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)//�����Ǵ�������
//ָ����������ʱʹ���ĸ������ļ�
@ContextConfiguration("classpath:yp/itcast/e_annotationaop/applicationContext.xml")
public class Demo {
	
	//����Ϊuser�Ķ���ע�뵽u������
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun(){
		us.save();
		
	}
}
