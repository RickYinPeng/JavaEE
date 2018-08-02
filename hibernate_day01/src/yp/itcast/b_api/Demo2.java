package yp.itcast.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;

//学习SessionFactory对象
// SessionFactory功能：用于创建操作数据库核心对象session对象的工厂；
//					  简单说功能就一个------创建session对象
//注意：
//		1：sessionfactory 负责保存和使用所有配置信息，消耗内存资源非常大
//    	2：sessionfactory属于线程安全的对象设计（不是synchronized）
//结论：保证web项目中，只创建一个sessionfactory
public class Demo2 {
	
	@Test
	//保存客户操作
	public void fun1(){
		//1 ：创建，调用空参构造
		Configuration conf = new Configuration();
		
		//2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		conf.configure();
	
		//3:读取指定orm元数据（扩展）（也就是读映射文件的），如果主配置中已经引入了映射配置，不需要手动记载；
		//conf.addResource(resourceName);
		//conf.addClass(persistentClass);
	
		//4：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
		
		//--------------------------------------------
		//5：获得session
		//打开一个新的session对象
		sf.openSession();
		//获得一个与线程绑定的session对象（明天讲解）
		sf.getCurrentSession();
		
		
		
	
	}
	
	
	
}
