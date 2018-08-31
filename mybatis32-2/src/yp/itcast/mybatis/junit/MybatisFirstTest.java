package yp.itcast.mybatis.junit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import yp.itcast.mybatis.pojo.User;

public class MybatisFirstTest {
	
	//成员变量
	
	
	
	@Test
	public void testMybatis() throws IOException {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//创建Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById",10);
		
		System.out.println(user);
	}
	//根据用户名称模糊查询用户列表
	@Test
	public void testfindUserByUsername() throws IOException {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//创建Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行sql语句
		List<User> users= sqlSession.selectList("test.findUserByUsername", "五");
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	//添加用户
	@Test
	public void testInsertUser() throws IOException {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//创建Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行sql语句
		User user = new User();
		user.setUsername("曾志伟");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("河北");
		int i = sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId());
	}
	
	//更新用户
		@Test
		public void testUpdateUserById() throws IOException {
			//加载核心配置文件
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//创建Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//执行sql语句
			User user = new User();
			user.setId(29);
			user.setUsername("曾志伟2");
			user.setBirthday(new Date());
			user.setSex("女");
			user.setAddress("宝鸡");
			sqlSession.update("test.UpdateUserById", user);
			sqlSession.commit();
			
		}
		
		//删除用户
		@Test
		public void testDeleteUserById() throws IOException {
			//加载核心配置文件
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//创建Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			sqlSession.update("test.deleteUserById", 29);
			sqlSession.commit();
			
		}
}
