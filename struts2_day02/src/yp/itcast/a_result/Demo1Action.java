package yp.itcast.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		System.out.println("Demo1Action.execute()");
		
		return SUCCESS;
	}
	
	
	
	
	
}
