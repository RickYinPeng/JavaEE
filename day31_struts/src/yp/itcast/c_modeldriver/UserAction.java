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
 * ʹ��ģ�������ķ�ʽ��ȡ�������ݵķ�ʽ
 * @author ����
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//ע�⣺ʹ��ģ�������ķ�ʽ��������ݵ�ģ�����ò���Ϊ��(����Ҫset����) ** һ��Ҫnew
	private User user = new User();
	
	/**
	 * �÷���struts2���԰�ֵջ�е����������װ��User������
	 */
	public User getModel() {
		return user;
	}
	
	public String register() throws Exception {
		System.out.println(user);
		
		/**
		 * �������ݵ�UIҳ��
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
