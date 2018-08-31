package yp.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import yp.itcast.mybatis.pojo.User;

public interface UserDao {
	
	//通过用户ID查询一个用户
	public User selectUserById(Integer id);
	
}
