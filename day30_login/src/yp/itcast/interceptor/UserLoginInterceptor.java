package yp.itcast.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

import yp.itcast.entity.User;
/**
 * 目标：拦截用户的权限
 * @author 鹏鹏
 *
 */
public class UserLoginInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	//前提：假设所有的请求都被这个拦截器拦截
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入拦截器");
		/**
		 * 问题：该拦截器不需要拦截 登录（user_login）和注册请求(user_register)
		 */
		//得到当前拦截的目标Action代理对象
		ActionProxy actionProxy = invocation.getProxy();
		
		//得到当前执行的action的方法
		String methodName = actionProxy.getMethod();// login/register
		
		if("login".equals(methodName) || "register".equals(methodName)){
			//放行
			System.out.println("登录注册则放行");
			return invocation.invoke();
		}
		
		//1):获取session域中的数据
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		User user = (User)session.get("user");
		
		//2):判断session域中的数据是否存在
		if(user==null){
			//3):如果不存在，则跳转到登录
			System.out.println("对象还未登录，请先登录");
			return "login";
		}else{
			//4):如果存在，则放行
			System.out.println("对象已经登录，放行");
			return invocation.invoke();
		}
	}
	
}
