package yp.itcast.service;

import yp.itcast.domain.User;

public interface UserService {
	
	//��¼����
	User getUserByCodePassword(User u);
	
	//ע���û�
	void saveUser(User u);
	
}
