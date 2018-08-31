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
	
	//һ��һ����
	@Test
	public void testselectOrders() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> selectOrders = orderMapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	
	//һ�Զ����
		@Test
		public void testselectUserList() throws Exception {
			//���غ��������ļ�
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//����SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//����Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> selectUserList = userMapper.selectUserList();
			for (User user : selectUserList) {
				System.out.println(user);
			}
		}
}
