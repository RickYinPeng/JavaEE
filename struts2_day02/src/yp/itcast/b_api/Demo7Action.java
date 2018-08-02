package yp.itcast.b_api;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//如何在action中获得原生的ServletAPI
public class Demo7Action extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;

	public String execute() throws Exception {
		
		System.out.println("原生request对象："+request);
		
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	
	
	
	
}
