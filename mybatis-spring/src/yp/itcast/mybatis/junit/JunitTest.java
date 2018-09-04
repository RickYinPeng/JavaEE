package yp.itcast.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.mybatis.mapper.UserMapper;
import yp.itcast.mybatis.pojo.User;

public class JunitTest {
	
	@Test
	public void test() {
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		
//		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
	
		User user = userMapper.selectUserById(10);
		
		System.out.println(user);
	}
}
