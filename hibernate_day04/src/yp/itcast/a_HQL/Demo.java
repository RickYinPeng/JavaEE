package yp.itcast.a_HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//学习HQL语法
public class Demo {
	
	
	//基本语法
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer";//完整写法
		String hql2 = " from Customer";//简单写法
		String hql3 = " from java.lang.Object";//扩展（好玩）
		
		Query query = session.createQuery(hql3);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//排序语法
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer order by cust_id asc";//完整写法
		String hql2 =  " from yp.itcast.domain.Customer order by cust_id desc";//完整写法
		
		Query query = session.createQuery(hql2);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//条件查询
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer where cust_id = ? ";//完整写法
		String hql2 =  " from Customer where cust_id= :id";//完整写法
		
		Query query = session.createQuery(hql2);
		
		//query.setParameter(0, 3l);
		query.setParameter("id", 3l);
		
		List<Customer> list = query.list();
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//分页查询
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql2 =  " from Customer";//完整写法
		
		Query query = session.createQuery(hql2);
		
		//limit ?,?
		//公式：起始页公式：（当前页数-1）*每页条数
		query.setFirstResult(2);
		query.setMaxResults(2);
		
		List<Customer> list = query.list();
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//统计查询
	//count
	//sum
	//avg
	//max
	//min
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql1 =  "select count(*) from Customer";
		String hql2 =  "select sum(cust_id) from Customer";
		String hql3 =  "select avg(cust_id) from Customer";
		String hql4 =  "select max(cust_id) from Customer";
		String hql5 =  "select min(cust_id) from Customer";
		
		Query query = session.createQuery(hql5);
		
		Number number = (Number) query.uniqueResult();
		System.out.println(number);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//投影查询(听起来高大上)
	public void fun6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql1 =  "select cust_id from Customer";
		String hql2 =  "select cust_id,cust_name from Customer";
		String hql3 =  "select new Customer(cust_id,cust_name) from Customer";
		
		Query query = session.createQuery(hql3);
		
		List list = query.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
}
