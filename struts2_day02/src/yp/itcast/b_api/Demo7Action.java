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


//�����action�л��ԭ����ServletAPI
public class Demo7Action extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;

	public String execute() throws Exception {
		
		System.out.println("ԭ��request����"+request);
		
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	
	
	
	
}
