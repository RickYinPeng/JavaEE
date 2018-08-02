package yp.itcast.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//�����action�л��ԭ����ServletAPI
public class Demo5Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		//request�����=>map
		//���Ƽ�
		Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
		//�Ƽ�
		ActionContext.getContext().put("name", "requestTom");
		
		//session��=>map
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "sessionTom");
		
		//application��Context��=>map
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationTom");
		
		
		return SUCCESS;
	}
	
	
	
	
	
}
