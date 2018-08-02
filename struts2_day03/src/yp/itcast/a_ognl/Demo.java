package yp.itcast.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import yp.itcast.bean.User;

//展示ognl语法
public class Demo {

	@Test
	//准备工作
	public void fun1() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		Ognl.getValue("", oc, oc.getRoot());
	}
	
	@Test
	//基本语法取值
	//取出Root中的数据
	public void fun2() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//取出root中user对象的name属性
		String name= (String) Ognl.getValue("name", oc, oc.getRoot());
		Integer age= (Integer) Ognl.getValue("age", oc, oc.getRoot());
		
		System.out.println("name:"+name);
		System.out.println("age:"+age);
	}
	
	@Test
	//基本语法取值
	//取出Context中的属性值
	public void fun3() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//取出root中user对象的name属性
		//"#":代表从Context中取
		//"user1":代表从Context中取出user1对应的键的值
		String name= (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		String name2= (String) Ognl.getValue("#user2.name", oc, oc.getRoot());
		Integer age= (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		
		System.out.println("name:"+name);
		System.out.println("name2:"+name2);
		System.out.println("age:"+age);
	}
	
	@Test
	//基本语法取值
	//为属性赋值
	public void fun4() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//取出root中的tom并给其赋值为jerry
		Ognl.getValue("name='jerry'", oc, oc.getRoot());
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		
		Ognl.getValue("#user1.name='郝强勇'", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		System.out.println(name2);
		
	}
	
	@Test
	//基本语法取值
	//调用方法
	public void fun5() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//取出root中的tom并给其赋值为jerry
		Ognl.getValue("setName('lilei')", oc, oc.getRoot());
		String name = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		
		String name2 = (String) Ognl.getValue("#user1.setName('lucy'),#user1.getName()", oc, oc.getRoot());
		System.out.println(name2);
	}
	
	@Test
	//基本语法取值
	//调用静态方法
	public void fun6() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//取出root中的tom并给其赋值为jerry
		String name = (String)Ognl.getValue("@yp.itcast.a_ognl.hahaUtils@echo('hello 强勇！')", oc, oc.getRoot());
		Double PI = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
		Double PI2 = (Double) Ognl.getValue("@@PI", oc, oc.getRoot());
		
		System.out.println(PI);
		System.out.println(PI2);
	}
	
	@Test
	//基本语法取值
	//OGNL创建对象---list|map
	public void fun7() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//创建list对象
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','jack','rose'}.size()", oc, oc.getRoot());
	//	String name = (String) Ognl.getValue("{'tom','jerry','jack','rose'}.[0]", oc, oc.getRoot());
		String name2 = (String)Ognl.getValue("{'tom','jerry','jack','rose'}.get(1)", oc, oc.getRoot());

		System.out.println(size);
	//	System.out.println(name);
		System.out.println(name2);
	}
	
	@Test
	//基本语法取值
	//OGNL创建对象---list|map
	public void fun8() throws OgnlException {
		
		//1：准备OGNLContext
			//准备Root
			User rootUser = new User("tom",18);
			//准备Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//书写OGNL
		
		//创建Map对象
		Integer size = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#{'name':'tom','age':18}.get('age')", oc, oc.getRoot());
	
		System.out.println(name);
		System.out.println(age);
		
	}
}
