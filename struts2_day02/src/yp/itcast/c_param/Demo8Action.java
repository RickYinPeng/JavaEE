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

//struts2如何获得参数---方式二：
//对象驱动
public class Demo8Action extends ActionSupport {
	
	public Demo8Action() {		
		super();
		System.out.println("Demo8Action.Demo8Action()");
	}


	//准备与参数键名称相同的属性
	private String name;
	//自动类型转换，只转换8大基本数据类型以及对应的包装类
	private Integer age;
	//支持特定类型字符串转换为Date类型，例如yyyy-MM-dd
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
