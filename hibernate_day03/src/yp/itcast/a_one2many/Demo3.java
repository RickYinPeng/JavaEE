package yp.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.utils.HibernateUtils;

//操作进阶---关系维护
public class Demo3 {
	
	@Test
	//保存客户以及客户下的联系人
	public void fun1(){
		//（1）：获得session
		Session session = HibernateUtils.openSession();
		//（2）：开启事务
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//（3）：操作
		Customer c = new Customer();
		c.setCust_name("传智播客");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黎活明");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("刘悦东");
		
		//表达一对多，客户下有多个联系人
		//customer已经不维护关系了，所以下面两行代码不需要了
/*		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);*/
		
		//表达多对一，联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(c);
		session.save(lm1);
		session.save(lm2);
		
		//-----------------------------------------------
		//（4）：提交事务
		tx.commit();
		//（5）：关闭资源
		session.close();
	}
	
	@Test
	//删除客户
	public void fun2(){
		//（1）：获得session
		Session session = HibernateUtils.openSession();
		//（2）：开启事务
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//（3）：操作
		Customer c = session.get(Customer.class, 1l);
			
		session.delete(c);
		//-----------------------------------------------
		//（4）：提交事务
		tx.commit();
		//（5）：关闭资源
		session.close();
	}
	
	@Test
	//保存联系人以及联系人对应的客户
	//cascade:save-update
	public void fun3(){
		//（1）：获得session
		Session session = HibernateUtils.openSession();
		//（2）：开启事务
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//（3）：操作
			Customer c = new Customer();
			c.setCust_name("北大青鸟");
			
			LinkMan lm1 = new LinkMan();
			lm1.setLkm_name("刘总");
			
			c.getLinkMens().add(lm1);
			
			lm1.setCustomer(c);
			
			session.save(lm1);
		
		//-----------------------------------------------
		//（4）：提交事务
		tx.commit();
		//（5）：关闭资源
		session.close();
	}
}
