package yp.itcast.dao;

import yp.itcast.domain.User;

public interface UserDao extends BaseDao<User>{
	
	//�����û���¼���Ʋ�ѯuser
	User getByUserCode(String usercode);

	
/*	
	//�����û�
	void save(User u);*/
}
