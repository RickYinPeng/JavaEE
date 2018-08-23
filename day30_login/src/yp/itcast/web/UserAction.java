package yp.itcast.web;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import yp.itcast.entity.User;

public class UserAction extends ActionSupport{
	private User user;//接收表单数据

	public String register() throws Exception {
		System.out.println("5):调用了UserAction的register方法");
	
		return SUCCESS;
	}
	public String login() throws Exception {
		if("eric".equals(user.getName()) &&
				"1234".equals(user.getPassword())){
			//登录成功！！！
			//1):保存数据到session域中
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			sessionMap.put("user",user);
			
			//2):跳转到用户主页
			return SUCCESS;
		}else{
			//失败
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
