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

//���������µ� �ӳټ��� & ץȡ����
public class Demo2 {

	@Test
	//fetch��select	�����ѯ
	//lazy��proxy����Customer������class��lazy���Ծ�����
		//customer-true	������
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
	//fetch��select	�����ѯ
	//lazy��proxy����Customer������class��lazy���Ծ�����
		//customer-false	����  ����
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
	//fetch��join	����ѯ
	//lazy��ʧЧ
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
