package yp.itcast.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//如何在action中获得原生的ServletAPI
public class Demo5Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		//request域对象=>map
		//不推荐
		Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
		//推荐
		ActionContext.getContext().put("name", "requestTom");
		
		//session域=>map
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "sessionTom");
		
		//application域（Context域）=>map
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationTom");
		
		
		return SUCCESS;
	}
	
	
	
	
	
}
