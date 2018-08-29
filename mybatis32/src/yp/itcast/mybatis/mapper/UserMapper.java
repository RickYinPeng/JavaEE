package yp.itcast.mybatis.mapper;

import yp.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	//遵循四个原则
	//1.接口方法名 == User.xml(Mapper.xml) 中的 id 名
	//2.返回值类型 与 User.xml(Mapper.xml) 文件中的返回值类型要一致
	//3.方法的入参类型要与User.xml(Mapper.xml) 文件中入参的类型要一致
	//4.命名空间 要绑定接口
	public User findUserById(Integer id);
	
	
}
