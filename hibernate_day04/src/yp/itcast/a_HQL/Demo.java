package yp.itcast.a_HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//ѧϰHQL�﷨
public class Demo {
	
	
	//�����﷨
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer";//����д��
		String hql2 = " from Customer";//��д��
		String hql3 = " from java.lang.Object";//��չ�����棩
		
		Query query = session.createQuery(hql3);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//�����﷨
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer order by cust_id asc";//����д��
		String hql2 =  " from yp.itcast.domain.Customer order by cust_id desc";//����д��
		
		Query query = session.createQuery(hql2);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//������ѯ
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql =  " from yp.itcast.domain.Customer where cust_id = ? ";//����д��
		String hql2 =  " from Customer where cust_id= :id";//����д��
		
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
	//��ҳ��ѯ
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql2 =  " from Customer";//����д��
		
		Query query = session.createQuery(hql2);
		
		//limit ?,?
		//��ʽ����ʼҳ��ʽ������ǰҳ��-1��*ÿҳ����
		query.setFirstResult(2);
		query.setMaxResults(2);
		
		List<Customer> list = query.list();
		System.out.println(list);
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//ͳ�Ʋ�ѯ
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
	//ͶӰ��ѯ(�������ߴ���)
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
