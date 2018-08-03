package yp.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yp.itcast.domain.User;
import yp.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() throws Exception {
		
		//1.调用Service执行登录逻辑
		userService.getUserByCodePassword(user);
		
		//2.将返回的User对象放入session域中
		ActionContext.getContext().getSession().put("user", user);
		
		//3.重定向到项目首页
		
		
		return "toHome";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
