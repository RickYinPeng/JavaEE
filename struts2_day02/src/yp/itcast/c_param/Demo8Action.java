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

//struts2��λ�ò���---��ʽ����
//��������
public class Demo8Action extends ActionSupport {
	
	public Demo8Action() {		
		super();
		System.out.println("Demo8Action.Demo8Action()");
	}


	//׼���������������ͬ������
	private String name;
	//�Զ�����ת����ֻת��8��������������Լ���Ӧ�İ�װ��
	private Integer age;
	//֧���ض������ַ���ת��ΪDate���ͣ�����yyyy-MM-dd
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String execute() throws Exception {
		
		System.out.println("name:"+name+",age:"+age+",birthday:"+birthday);
		
		return SUCCESS;
	}
	
}
