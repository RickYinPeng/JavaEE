package yp.itcast.f_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试criteria语句
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
		
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的Customer对象
		
		List<Customer> list = criteria.list();
		
		//Customer c = (Customer)criteria.uniqueResult();
		
		System.out.println(list);
		
		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//条件查询 
	// >				:gt
	// >=				:ge
	// <				:lt
	// <=				:le
	// ==				:eq
	// !=				:ne
	// in				:in
	// between and		:between
	// like				:like
	// is not null		:isNotNULL
	// is null			:isNull
	// or				:or
	// and				:and
	public void fun2(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
		
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		//添加查询参数=>查询cust_id为1的Customer对象
		criteria.add(Restrictions.eq("cust_id", 1l));
		
		//执行查询获得的结果
		Customer c = (Customer)criteria.uniqueResult();
		
		System.out.println(c);
		//-------------------------------------------------------
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//分页查询
	public void fun3(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
				
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		//设置分页信息
		criteria.setFirstResult(1);
		criteria.setMaxResults(1);
		
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//查询总记录数
	public void fun4(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
				
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		//设置查询的聚合函数=>总行数
		criteria.setProjection(Projections.rowCount());
		
		Long count = (Long) criteria.uniqueResult();
		
		System.out.println(count);
		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	
}
