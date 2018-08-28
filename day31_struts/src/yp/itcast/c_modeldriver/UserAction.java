package yp.itcast.c_modeldriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yp.itcast.b_validate.User;
/**
 * 使用模型驱动的方式获取请求数据的方式
 * @author 鹏鹏
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//注意：使用模型驱动的方式，存放数据的模型引用不能为空(不需要set方法) ** 一定要new
	private User user = new User();
	
	/**
	 * 该方法struts2可以把值栈中的请求参数封装到User对象中
	 */
	public User getModel() {
		return user;
	}
	
	public String register() throws Exception {
		System.out.println(user);
		
		/**
		 * 传递内容到UI页面
		 */
		List<User> list = new ArrayList<User>();
		list.add(new User("eric","1234"));
		list.add(new User("jacky","5678"));
		list.add(new User("rose","4321"));
		
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> requestMap = ac.getContextMap();
		requestMap.put("userList", list);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("101", "eric");
		map.put("102", "mark");
		map.put("103", "maxwell");
		map.put("104", "rolse");
		requestMap.put("userMap", map);
		
		requestMap.put("userName", "jacky");
		requestMap.put("password","123456");
		
		return "ui";
	}
}
