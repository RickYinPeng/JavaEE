package yp.itcast.a_i18n;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		//获取资源包的内容
		String name = super.getText("user");
		System.out.println(name);
		return super.execute();
	}
}
