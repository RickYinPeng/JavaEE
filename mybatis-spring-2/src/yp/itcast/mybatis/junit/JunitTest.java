package yp.itcast.mybatis.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yp.itcast.mybatis.mapper.UserMapper;
import yp.itcast.mybatis.pojo.User;
import yp.itcast.mybatis.pojo.UserExample;
import yp.itcast.mybatis.pojo.UserExample.Criteria;


public class JunitTest {
	
	@Test
	public void test() {
		//1��������������src���ң�
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = ac.getBean(UserMapper.class);
		
		UserExample example = new UserExample();
		String username = "��";
		
		//������ѯ
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+username+"%");
		
		//����id���򣨽��򣩲�ѯ
		example.setOrderByClause("id desc");
		
		//��ѯ����
		int i = userMapper.countByExample(example);
		
		System.out.println(i);
		
		//����id��ѯ
		User user = userMapper.selectByPrimaryKey(10);
		
		System.out.println(user);
		
		//����������ѯ
		List<User> list = userMapper.selectByExample(example);
		for (User user2 : list) {
			System.out.println(user2.getId());
		}
		
		//����
		
	}
}
