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

import yp.itcast.domain.User;

//struts2如何获得参数--方式一
//每次请求Action时都会创建新的Action实例对象
public class Demo9Action extends ActionSupport {
	
	//准备一个User对象
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		
		System.out.println(user);
		
		return SUCCESS;
	}
	
}
