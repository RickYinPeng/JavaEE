package yp.itcast.mybatis.mapper;

import java.util.List;

import yp.itcast.mybatis.pojo.QueryVo;
import yp.itcast.mybatis.pojo.User;

public interface UserMapper {
	
	//��ѭ�ĸ�ԭ��
	//1.�ӿڷ����� == User.xml(Mapper.xml) �е� id ��
	//2.����ֵ���� �� User.xml(Mapper.xml) �ļ��еķ���ֵ����Ҫһ��
	//3.�������������Ҫ��User.xml(Mapper.xml) �ļ�����ε�����Ҫһ��
	//4.�����ռ� Ҫ�󶨽ӿ�
	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//��ѯ��������
	public Integer countUser();
	
	//�����Ա�����ֲ�ѯ�û�
	public List<User> selectUserBySexAndUsername(User user);
	
	//���ݶ��id��ѯ�û���Ϣ
//	public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIds(List<Integer> ids);
//	public List<User> selectUserByIds(QueryVo vo);

	//һ�Զ����
	public List<User> selectUserList();


}
