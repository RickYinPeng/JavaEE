package yp.itcast.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import yp.itcast.bean.User;

//չʾognl�﷨
public class Demo {

	@Test
	//׼������
	public void fun1() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		Ognl.getValue("", oc, oc.getRoot());
	}
	
	@Test
	//�����﷨ȡֵ
	//ȡ��Root�е�����
	public void fun2() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root��user�����name����
		String name= (String) Ognl.getValue("name", oc, oc.getRoot());
		Integer age= (Integer) Ognl.getValue("age", oc, oc.getRoot());
		
		System.out.println("name:"+name);
		System.out.println("age:"+age);
	}
	
	@Test
	//�����﷨ȡֵ
	//ȡ��Context�е�����ֵ
	public void fun3() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root��user�����name����
		//"#":�����Context��ȡ
		//"user1":�����Context��ȡ��user1��Ӧ�ļ���ֵ
		String name= (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		String name2= (String) Ognl.getValue("#user2.name", oc, oc.getRoot());
		Integer age= (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		
		System.out.println("name:"+name);
		System.out.println("name2:"+name2);
		System.out.println("age:"+age);
	}
	
	@Test
	//�����﷨ȡֵ
	//Ϊ���Ը�ֵ
	public void fun4() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root�е�tom�����丳ֵΪjerry
		Ognl.getValue("name='jerry'", oc, oc.getRoot());
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		
		Ognl.getValue("#user1.name='��ǿ��'", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		System.out.println(name2);
		
	}
	
	@Test
	//�����﷨ȡֵ
	//���÷���
	public void fun5() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root�е�tom�����丳ֵΪjerry
		Ognl.getValue("setName('lilei')", oc, oc.getRoot());
		String name = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		
		String name2 = (String) Ognl.getValue("#user1.setName('lucy'),#user1.getName()", oc, oc.getRoot());
		System.out.println(name2);
	}
	
	@Test
	//�����﷨ȡֵ
	//���þ�̬����
	public void fun6() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root�е�tom�����丳ֵΪjerry
		String name = (String)Ognl.getValue("@yp.itcast.a_ognl.hahaUtils@echo('hello ǿ�£�')", oc, oc.getRoot());
		Double PI = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
		Double PI2 = (Double) Ognl.getValue("@@PI", oc, oc.getRoot());
		
		System.out.println(PI);
		System.out.println(PI2);
	}
	
	@Test
	//�����﷨ȡֵ
	//OGNL��������---list|map
	public void fun7() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//����list����
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','jack','rose'}.size()", oc, oc.getRoot());
	//	String name = (String) Ognl.getValue("{'tom','jerry','jack','rose'}.[0]", oc, oc.getRoot());
		String name2 = (String)Ognl.getValue("{'tom','jerry','jack','rose'}.get(1)", oc, oc.getRoot());

		System.out.println(size);
	//	System.out.println(name);
		System.out.println(name2);
	}
	
	@Test
	//�����﷨ȡֵ
	//OGNL��������---list|map
	public void fun8() throws OgnlException {
		
		//1��׼��OGNLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("Rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//����Map����
		Integer size = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#{'name':'tom','age':18}.get('age')", oc, oc.getRoot());
	
		System.out.println(name);
		System.out.println(age);
		
	}
}
