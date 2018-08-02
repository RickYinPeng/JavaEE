package yp.itcast.c_param;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yp.itcast.domain.User;

//struts2如何获得参数---方式三
//模型驱动
public class Demo10Action extends ActionSupport implements ModelDriven<User>{
	
	//准备User：成员变量（一定要初始化了就是new了）
	private User user = new User();

	public String execute() throws Exception {
		
		System.out.println("开始");
		System.out.println(user);
		
		return SUCCESS;
	}
	
	public User getModel() {
		return user;
	}
	
}
