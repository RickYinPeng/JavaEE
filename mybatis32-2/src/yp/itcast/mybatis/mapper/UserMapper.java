package yp.itcast.mybatis.mapper;

import java.util.List;

import yp.itcast.mybatis.pojo.QueryVo;
import yp.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	//遵循四个原则
	//1.接口方法名 == User.xml(Mapper.xml) 中的 id 名
	//2.返回值类型 与 User.xml(Mapper.xml) 文件中的返回值类型要一致
	//3.方法的入参类型要与User.xml(Mapper.xml) 文件中入参的类型要一致
	//4.命名空间 要绑定接口
	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//查询数据条数
	public Integer countUser();
	
	//根据性别和名字查询用户
	public List<User> selectUserBySexAndUsername(User user);
	
	//根据多个id查询用户信息
//	public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIds(List<Integer> ids);
//	public List<User> selectUserByIds(QueryVo vo);

	//一对多关联
	public List<User> selectUserList();


}
