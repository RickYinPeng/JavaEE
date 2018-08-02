package yp.itcast.e_fetchsize;

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

//ץȡ����
public class Demo {
	
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql = "from Customer ";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		
		for (Customer c : list) {
			System.out.println(c.getLinkMens());
		}
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
}
