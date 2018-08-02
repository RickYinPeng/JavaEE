package yp.itcast.d_tx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试getCurrentSession
public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.getCurrentSession();
		
		Session session2 = HibernateUtils.getCurrentSession();
		
		Session session3 = HibernateUtils.openSession();
		System.out.println(session==session2);//true
		System.out.println(session==session3);//false
	}
	
	
}
