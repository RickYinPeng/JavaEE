package yp.itcast.d_lazy_fetch;

import java.util.List;
import java.util.Set;

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
import yp.itcast.domain.LinkMan;
import yp.itcast.utils.HibernateUtils;

//关联级别下的 延迟加载 & 抓取策略
public class Demo2 {

	@Test
	//fetch：select	单表查询
	//lazy：proxy（由Customer配置中class的lazy属性决定）
		//customer-true	懒加载
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 4l);
		Customer c = lm.getCustomer();
		
		System.out.println(c);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//fetch：select	单表查询
	//lazy：proxy（由Customer配置中class的lazy属性决定）
		//customer-false	立即  加载
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 4l);
		Customer c = lm.getCustomer();
		
		System.out.println(c);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//fetch：join	多表查询
	//lazy：失效
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 4l);
		Customer c = lm.getCustomer();
		
		System.out.println(c);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
}
