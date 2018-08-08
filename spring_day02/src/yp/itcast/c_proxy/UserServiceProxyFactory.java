package yp.itcast.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import yp.itcast.service.UserService;
import yp.itcast.service.UserServiceImpl;

//观光代码=>动态代理
public class UserServiceProxyFactory implements InvocationHandler{
	
	private UserService us;

	public UserServiceProxyFactory(UserService us) {
		super();
		this.us = us;
	}

	public UserService getUserServiceProxy(){
		//生成动态代理返回
		UserService usProxy = (UserService) Proxy.newProxyInstance(
				UserServiceProxyFactory.class.getClassLoader(), 
				UserServiceImpl.class.getInterfaces(),
				this
				);
		//返回
		return usProxy;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("打开事务！！！");
		
		System.out.println("proxy:"+proxy.getClass().getName());
		System.out.println("method:"+method.getName());
		Object invoke = method.invoke(us, args);
		
		System.out.println("关闭事务！！！");
		
		return invoke;
	}
}
