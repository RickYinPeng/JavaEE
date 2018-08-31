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

public class MybatisMpperTest {
	
	@Test
	public void testMapper() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(10);
		
		System.out.println(user);
	}
	
	@Test
	public void testMapperQueryVo() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("��");
		vo.setUser(user);
		
		List<User> list = userMapper.findUserByQueryVo(vo);
		for (User u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testMapperCountUser() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Integer count = userMapper.countUser();
	
		System.out.println(count);
	}
	
	
	@Test
	public void testOrderList() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> list = orderMapper.selectOrdersList();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	//�����Ա�����ֲ�ѯ�û�
	@Test
	public void testselectUserBySexAndUsername() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setSex("1"); 
		user.setUsername("��С��");
		 
		List<User> users = userMapper.selectUserBySexAndUsername(user);
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	//���Id
	@Test
	public void testselectUserByIds() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSession��������һ��ʵ���ࣨ���ӿڲ��ҽӿڵ���ѭ�Ĵ�ԭ��
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(10);
		ids.add(16);
		ids.add(22);
		ids.add(24);
/*		QueryVo vo = new QueryVo();
		vo.setIdsList(ids);*/
/*		List<Integer> list = new ArrayList<Integer>();
		Integer[] ids = new Integer[3];
		ids[0] = 16;
		ids[1] = 22;
		ids[2] = 24;*/
		
//		List<User> list = userMapper.selectUserByIds(vo);
		List<User> users = userMapper.selectUserByIds(ids);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
}
