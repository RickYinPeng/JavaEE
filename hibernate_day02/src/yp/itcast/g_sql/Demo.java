package yp.itcast.g_sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试原生SQL语句
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
		
		//(1):写sql语句
		String sql = "select * from cst_customer";
		
		//(2):创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		//(3):调用方法查询结果
		List<Object[]> list = query.list();
		
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//基本查询
	public void fun2(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
		
		//(1):写sql语句
		String sql = "select * from cst_customer";
		
		//(2):创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.addEntity(Customer.class);
		
		
		//(3):调用方法查询结果
		List<Customer> list = query.list();
		
		System.out.println(list);

		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//条件查询
	public void fun3(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
		
		//(1):写sql语句
		String sql = "select * from cst_customer where cust_id=?";
		
		//(2):创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 1l);
		
		//指定将结果集封装到哪个对象中
		query.addEntity(Customer.class);
		
		
		//(3):调用方法查询结果
		List<Customer> list = query.list();
		
		System.out.println(list);

		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//分页查询
	public void fun4(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		//-------------------------------------------------------
		
		//(1):写sql语句
		String sql = "select * from cst_customer limit ?,?";
		
		//(2):创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 0);
		query.setParameter(1, 1);
		
		//指定将结果集封装到哪个对象中
		query.addEntity(Customer.class);
		
		
		//(3):调用方法查询结果
		List<Customer> list = query.list();
		
		System.out.println(list);

		//-------------------------------------------------------
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
}
