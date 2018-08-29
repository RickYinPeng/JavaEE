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
	
	//��Ա����
	
	
	
	@Test
	public void testMybatis() throws IOException {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��sql���
		User user = sqlSession.selectOne("test.findUserById",10);
		
		System.out.println(user);
	}
	//�����û�����ģ����ѯ�û��б�
	@Test
	public void testfindUserByUsername() throws IOException {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��sql���
		List<User> users= sqlSession.selectList("test.findUserByUsername", "��");
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	//����û�
	@Test
	public void testInsertUser() throws IOException {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//����Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��sql���
		User user = new User();
		user.setUsername("��־ΰ");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("�ӱ�");
		int i = sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId());
	}
	
	//�����û�
		@Test
		public void testUpdateUserById() throws IOException {
			//���غ��������ļ�
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//����SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//����Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//ִ��sql���
			User user = new User();
			user.setId(29);
			user.setUsername("��־ΰ2");
			user.setBirthday(new Date());
			user.setSex("Ů");
			user.setAddress("����");
			sqlSession.update("test.UpdateUserById", user);
			sqlSession.commit();
			
		}
		
		//ɾ���û�
		@Test
		public void testDeleteUserById() throws IOException {
			//���غ��������ļ�
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			
			//����SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			//����Sqlsession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			sqlSession.update("test.deleteUserById", 29);
			sqlSession.commit();
			
		}
}
