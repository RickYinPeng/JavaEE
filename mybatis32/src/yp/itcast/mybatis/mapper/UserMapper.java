package yp.itcast.mybatis.mapper;

import yp.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	//��ѭ�ĸ�ԭ��
	//1.�ӿڷ����� == User.xml(Mapper.xml) �е� id ��
	//2.����ֵ���� �� User.xml(Mapper.xml) �ļ��еķ���ֵ����Ҫһ��
	//3.�������������Ҫ��User.xml(Mapper.xml) �ļ�����ε�����Ҫһ��
	//4.�����ռ� Ҫ�󶨽ӿ�
	public User findUserById(Integer id);
	
	
}
