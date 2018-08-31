package yp.itcast.mybatis.junit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import yp.itcast.mybatis.mapper.OrderMapper;
import yp.itcast.mybatis.mapper.UserMapper;
import yp.itcast.mybatis.pojo.Orders;
import yp.itcast.mybatis.pojo.QueryVo;
import yp.itcast.mybatis.pojo.User;

public class MybatisMpperTest2 {
	
	//一对一测试
	@Test
	public void testselectOrders() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//创建Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession帮我生成一个实现类（给接口并且接口得遵循四大原则）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> selectOrders = orderMapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	
	//一对多测试
		@Test
		public void testselectUserList() throws Exception {
			//加载核心配置文件
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//创建Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//SqlSession帮我生成一个实现类（给接口并且接口得遵循四大原则）
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> selectUserList = userMapper.selectUserList();
			for (User user : selectUserList) {
				System.out.println(user);
			}
		}
}
