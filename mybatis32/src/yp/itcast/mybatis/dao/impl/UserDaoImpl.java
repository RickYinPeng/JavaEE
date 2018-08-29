package yp.itcast.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import yp.itcast.mybatis.dao.UserDao;
import yp.itcast.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	
	//通过用户ID查询一个用户
	public User selectUserById(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
	
		return user;
	}
	
	//通过用户名称模糊查询
	public List<User> selectUserByUsername(String username){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByUsername", username);
	
		return list;
	}
	
}
