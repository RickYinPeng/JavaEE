package yp.itcast.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import yp.itcast.entity.User;

public class UserAction extends ActionSupport{
	private User user;//���ձ�����

	public String register() throws Exception {
		System.out.println("5):������UserAction��register����");
	
		return SUCCESS;
	}
	public String login() throws Exception {
		if("eric".equals(user.getName()) &&
				"1234".equals(user.getPassword())){
			//��¼�ɹ�������
			//1):�������ݵ�session����
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			sessionMap.put("user",user);
			
			//2):��ת���û���ҳ
			return SUCCESS;
		}else{
			//ʧ��
			return "error";
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
