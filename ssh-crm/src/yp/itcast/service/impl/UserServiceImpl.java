package yp.itcast.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import yp.itcast.dao.UserDao;
import yp.itcast.domain.User;
import yp.itcast.service.UserService;
import yp.itcast.utils.MD5Utils;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao ud;
	
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User getUserByCodePassword(User u) {
		//1.根据登录名称查询登录用户
		User exisU = ud.getByUserCode(u.getUser_code());
		//2.判断用户是否存在，不存在=>抛出异常，提示用户不存在
		if(exisU==null){
			throw new RuntimeException("用户名不存在！！！");
		}
		//3.判断用户密码是否正确，不正确=>抛出异常，提示密码错误
		if(!exisU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
			throw new RuntimeException("密码错误！！！");
		} 
		//4.返回查询到的用户对象
		
		
		return exisU;
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		//1.调用Dao根据注册的登录名获得用户对象
		User existU = ud.getByUserCode(u.getUser_code());
		//2.如果获得user对象，用户名已经存在，抛出异常
		if(existU!=null){
			throw new RuntimeException("用户名已经存在！！！");
		}
		//使用MD5对密码进行加密
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		
		//3.调用Dao执行保存
		ud.save(u);
	}
	
}
