package yp.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import yp.itcast.mybatis.pojo.User;

public interface UserDao {
	
	//ͨ���û�ID��ѯһ���û�
	public User selectUserById(Integer id);
	
}
