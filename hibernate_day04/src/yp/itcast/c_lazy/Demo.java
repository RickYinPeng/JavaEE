package yp.itcast.c_lazy;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//懒加载|延迟加载
public class Demo {
	
	
	@Test
	//get方法：debug后发现，执行方法时立即发送sql语句查询结果
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		System.out.println(c);
		
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//	load方法:是在执行时，不发生任何sql语句，会先返回一个对象，在使用到该对象时才执行查询
	//	延迟加载：仅仅获得没有使用，不会查询，在使用到的时候才进行查询
	//	是否对类进行延迟加载：可以通过在class元素上配置lazy属性来控制
			//lazy：true		加载时，不查询，使用时才查询
			//    ：false	加载时立即查询（跟get没有任何区别）
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.load(Customer.class, 3l);
		
		System.out.println(c);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
}
