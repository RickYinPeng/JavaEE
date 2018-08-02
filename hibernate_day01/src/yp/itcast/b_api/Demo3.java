package yp.itcast.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;

//学习Session对象
// Session（翻译：会话（一次会话，一次链接（web服务器，邮件服务器）））功能：表达hibernate框架与数据库之间的连接（会话）。
//			session类似于JDBC年代的connection对象，还可以完成对数据库中数据的增删改查操作
//			session是hibernate操作数据库的核心对象
public class Demo3 {
	
	@Test
	//事务操作
	public void fun1(){
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
			
		//3:获得session
		Session session = sf.openSession();
		
		//4:session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象（建议使用）
		Transaction tx2 = session.beginTransaction();
		//--------------------------------------------------
		
		
		
		//--------------------------------------------------
		tx2.commit();//提交事务
		tx2.rollback();//回滚事务
		session.close();//释放资源
		sf.close();//释放资源
	
	}
	
	@Test
	//session的新增功能
	public void fun2(){
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
			
		//3:获得session
		Session session = sf.openSession();
		
		//4:session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象（建议使用）
		Transaction tx2 = session.beginTransaction();
		//--------------------------------------------------
		Customer c = new Customer();
		c.setCust_name("宝鸡");
		
		session.save(c);
		
		//--------------------------------------------------
		tx2.commit();//提交事务
		session.close();//释放资源
		sf.close();//释放资源
	
	}
	
	@Test
	//session的查询功能（今天只学习根据id查询）
	//查询id为1的customer对象
	public void fun3(){
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
			
		//3:获得session
		Session session = sf.openSession();
		
		//4:session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象（建议使用）
		Transaction tx2 = session.beginTransaction();
		//--------------------------------------------------
		Customer customer = session.get(Customer.class, 1l);//因为customer类中的id字段为Long类型，所以1后面要加一个l
		System.out.println(customer);
		//--------------------------------------------------
		tx2.commit();//提交事务
		session.close();//释放资源
		sf.close();//释放资源
	
	}
	
	@Test
	//session的修改功能
	//查询id为1的customer对象的name属性为黑马程序员
	public void fun4(){
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
			
		//3:获得session
		Session session = sf.openSession();
		
		//4:session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象（建议使用）
		Transaction tx2 = session.beginTransaction();
		//--------------------------------------------------
		//1:获得要修改的对象
		Customer customer = session.get(Customer.class, 1l);
		
		//2：修改
		customer.setCust_name("黑马程序员");
		//3：执行update
		session.update(customer);
		
		
		//--------------------------------------------------
		tx2.commit();//提交事务
		session.close();//释放资源
		sf.close();//释放资源
	
	}
	
	@Test
	//session的删除功能
	//删除id为1的customer对象
	public void fun5(){
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		SessionFactory sf = conf.buildSessionFactory();
			
		//3:获得session
		Session session = sf.openSession();
		
		//4:session获得操作事务的Transaction对象
		//获得操作事务的tx对象
		//Transaction tx = session.getTransaction();
		//开启事务并获得操作事务的对象（建议使用）
		Transaction tx2 = session.beginTransaction();
		//--------------------------------------------------
		//1:获得要修改的对象
		Customer customer = session.get(Customer.class, 1l);
		//2:执行delete
		session.delete(customer);
		
		//--------------------------------------------------
		tx2.commit();//提交事务
		session.close();//释放资源
		sf.close();//释放资源
	
	}
	
}
