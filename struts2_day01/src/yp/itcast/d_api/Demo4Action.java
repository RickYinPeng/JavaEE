package yp.itcast.d_api;

import com.opensymphony.xwork2.Action;

//方式二：实现一个接口Action
// 里面有execute方法，提供action方法的规范
// Action接口预置了一些字符串,可以在返回结果时使用
public class Demo4Action implements Action {

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
