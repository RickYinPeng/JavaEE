package yp.itcast.b_api;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//�����action�л��ԭ����ServletAPI
public class Demo6Action extends ActionSupport{

	//�����Ƽ�
	public String execute() throws Exception {
		//ԭ��request
		HttpServletRequest request = ServletActionContext.getRequest();
		//ԭ��session
		HttpSession session = request.getSession();
		//ԭ��response
		HttpServletResponse response = ServletActionContext.getResponse();
		//ԭ��servletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		return SUCCESS;
	}
	
	
	
	
	
}
