package yp.itcast.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import yp.itcast.mybatis.dao.UserDao;
import yp.itcast.mybatis.dao.impl.UserDaoImpl;
import yp.itcast.mybatis.pojo.User;

public class MybatisDaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before() throws IOException {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testDao() throws Exception {
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.selectUserById(10);
		
		System.out.println(user);
		
	}
}
