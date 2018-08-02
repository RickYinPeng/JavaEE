package yp.itcast.b_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//ѧϰ����Criteria
public class Demo2 {
	
	@Test
	public void fun1(){
		//Service/web��
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		dc.add(Restrictions.idEq(6l));//ƴװ������ȫ������ͨCriteriaһ�£�
		
		//---------------------------------------------------
		//������Dao��
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Criteria c = dc.getExecutableCriteria(session);
		
		List list = c.list();
		
		System.out.println(list);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
}
