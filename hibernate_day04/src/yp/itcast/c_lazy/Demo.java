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

//������|�ӳټ���
public class Demo {
	
	
	@Test
	//get������debug���֣�ִ�з���ʱ��������sql����ѯ���
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
	//	load����:����ִ��ʱ���������κ�sql��䣬���ȷ���һ��������ʹ�õ��ö���ʱ��ִ�в�ѯ
	//	�ӳټ��أ��������û��ʹ�ã������ѯ����ʹ�õ���ʱ��Ž��в�ѯ
	//	�Ƿ��������ӳټ��أ�����ͨ����classԪ��������lazy����������
			//lazy��true		����ʱ������ѯ��ʹ��ʱ�Ų�ѯ
			//    ��false	����ʱ������ѯ����getû���κ�����
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
