package yp.itcast.b_criteria;

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

//ѧϰCriteria�﷨
public class Demo {
	
	
	//�����﷨
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria criteria = session.createCriteria(Customer.class);
		
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	//�����﷨
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		
		c.add(Restrictions.idEq(3l));
		
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	//��ҳ��ѯ
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		
		
		c.setFirstResult(0);
		c.setMaxResults(2);
		
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}		
	
	//�����ѯ
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		
		c.addOrder(Order.asc("cust_id"));
		//c.addOrder(Order.desc("cust_id"));
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}	
	
	//ͳ��
	@Test
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		
		//���ò�ѯĿ�꣨�ۺϺ�����
		c.setProjection(Projections.rowCount());
		
		List list = c.list();
		
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}	
	

}
