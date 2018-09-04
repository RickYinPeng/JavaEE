package yp.itcast.mybatis.mapper;

import yp.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	public User selectUserById(Integer id);
}
