package yp.itcast.c_param;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import yp.itcast.bean.User;

public class Demo2Action extends ActionSupport implements ModelDriven<User>{

	private User u = new User();
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(u);
		
		return SUCCESS;
	}

/*	public void prepare() throws Exception {
		//压入栈顶
			//1：获得值栈
			ValueStack vs = ActionContext.getContext().getValueStack();
				
			//2：将u压入栈顶
			vs.push(u);
	}*/

	public User getModel() {
		return u;
	}

}
