package yp.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yp.itcast.domain.User;
import yp.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	private UserService userService;

	public String login() throws Exception {
		System.out.println("进入登录逻辑！！！");
		
		
		//1.调用Service执行登录逻辑
		User u = userService.getUserByCodePassword(user);
		
		System.out.println("u:"+u);
		
		//2.将返回的User对象放入session域中
		ActionContext.getContext().getSession().put("user", u);
		
		//3.重定向到项目首页
		
		
		return "toHome";
	}
	public String regist() throws Exception {
		
		//1.调用Service保存注册用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			//需要手动去放入
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		
		//2.重定向到登录页面
		return "toLogin";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
