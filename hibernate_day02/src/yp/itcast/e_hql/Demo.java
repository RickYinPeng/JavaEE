package yp.itcast.e_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试HQL语句
public class Demo {
	
	@Test
	//基本查询
	public void fun1(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
		
		//(1): 书写HQL语句
		/**
		 * String hql = "select * from 对象的完整类名"
		 * 如果查询其所有属性则前面的select * 可以省略
		 * String hql = " from 对象的完整类名"(如果对象没有重复存在，则可以直接写类名)
		 */
//		String hql = "from yp.itcast.domain.Customer";
		String hql = "from Customer";//查询所有Customer对象
		//(2): 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//(3): 根据查询对象获得查询结果
		List<Customer> list = query.list();//返回list结果（多个）
		//Object o = query.uniqueResult();//接受唯一的查询结果（一个）
		System.out.println(list);
		
		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//条件查询 
	//HQL语句中，不可能出现任何数据库相关的信息的
	public void fun2(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//(1): 书写HQL语句
		String hql = "from Customer where cust_id=1";
		
		//(2): 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		
		//(3): 根据查询对象获得查询结果
		Customer c = (Customer)query.uniqueResult();
		
		System.out.println(c);
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//条件查询
	//问号占位符
	public void fun3(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//(1): 书写HQL语句
		String hql = " from Customer where cust_id= ?";
		
		//(2): 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		
		//设置参数
		//query.setLong(0, 1);//注意：jdbc中第一个？位置为1，而hibernate中是从0开始的
		query.setParameter(0, 1l);
		
		//(3): 根据查询对象获得查询结果
		Customer c = (Customer)query.uniqueResult();
		
		System.out.println(c);
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//条件查询
	//命名占位符
	public void fun4(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//(1): 书写HQL语句
		String hql = " from Customer where cust_id= :cust_id";
		
		//(2): 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		
		//设置参数
		//query.setLong(0, 1);//注意：jdbc中第一个？位置为1，而hibernate中是从0开始的
		query.setParameter("cust_id", 1l);
		
		//(3): 根据查询对象获得查询结果
		Customer c = (Customer)query.uniqueResult();
		
		System.out.println(c);
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//分页查询
	public void fun5(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//(1): 书写HQL语句
		String hql = " from Customer ";
		
		//(2): 根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		
		//设置分页信息 limit ?,?
		query.setFirstResult(2);
		query.setMaxResults(2);
		
		//(3): 根据查询对象获得查询结果
		List<Customer> list = query.list();
		
		System.out.println(list);
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
}
