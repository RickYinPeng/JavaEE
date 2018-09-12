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
		//1：创建容器对象（src下找）
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = ac.getBean(UserMapper.class);
		
		UserExample example = new UserExample();
		String username = "明";
		
		//条件查询
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+username+"%");
		
		//按照id排序（降序）查询
		example.setOrderByClause("id desc");
		
		//查询数量
		int i = userMapper.countByExample(example);
		
		System.out.println(i);
		
		//按照id查询
		User user = userMapper.selectByPrimaryKey(10);
		
		System.out.println(user);
		
		//按照条件查询
		List<User> list = userMapper.selectByExample(example);
		for (User user2 : list) {
			System.out.println(user2.getId());
		}
		
		//保存
		
	}
}
