package yp.itcast.c_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import yp.itcast.service.UserService;
import yp.itcast.service.UserServiceImpl;

//观光代码=>cglib代理
public class UserServiceProxyFactory2 implements MethodInterceptor{
	

	public UserService getUserServiceProxy(){
		//帮我们生成代理对象
		Enhancer en = new Enhancer();
		
		//设置对谁进行代理
		en.setSuperclass(UserServiceImpl.class);
		
		//设置代理要做什么
		en.setCallback(this);
		
		UserService us = (UserService) en.create();
	
		return us;
	}

	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//打开事务
		System.out.println("打开事务!!!");
		
		//调用原有方法
		Object returnvalue = methodProxy.invokeSuper(obj, arg);
		
		//提交事务
		System.out.println("提交事务!!!");
		return returnvalue;
	}
}
