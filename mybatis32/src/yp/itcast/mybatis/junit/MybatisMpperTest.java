package yp.itcast.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import yp.itcast.mybatis.mapper.UserMapper;
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
}
