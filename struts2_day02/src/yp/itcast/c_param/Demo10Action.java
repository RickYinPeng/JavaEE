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

//struts2��λ�ò���---��ʽ��
//ģ������
public class Demo10Action extends ActionSupport implements ModelDriven<User>{
	
	//׼��User����Ա������һ��Ҫ��ʼ���˾���new�ˣ�
	private User user = new User();

	public String execute() throws Exception {
		
		System.out.println("��ʼ");
		System.out.println(user);
		
		return SUCCESS;
	}
	
	public User getModel() {
		return user;
	}
	
}
