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
	
	
	
	//ͨ���û�ID��ѯһ���û�
	public User selectUserById(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
	
		return user;
	}
	
	//ͨ���û�����ģ����ѯ
	public List<User> selectUserByUsername(String username){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByUsername", username);
	
		return list;
	}
	
}
