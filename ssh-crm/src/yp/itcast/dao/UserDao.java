package yp.itcast.dao;

import yp.itcast.domain.User;

public interface UserDao extends BaseDao<User>{
	
	//根据用户登录名称查询user
	User getByUserCode(String usercode);

	
/*	
	//保存用户
	void save(User u);*/
}
