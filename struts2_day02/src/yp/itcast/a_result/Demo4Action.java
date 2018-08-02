package yp.itcast.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo4Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		System.out.println("Demo3Action.execute()");
		
		return SUCCESS;
	}
	
	
}
