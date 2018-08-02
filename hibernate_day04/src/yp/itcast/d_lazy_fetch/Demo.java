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
public class Demo {
	
	
	@Test
	//���ϼ���Ĺ���
	//fetch��select	�����ѯ
	//lazy��true		ʹ��ʱ�ż��ؼ������ݣ�ע���Ǽ������ݣ�
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//��������ͨ��һ�������ҵ�һ���������������ԣ�
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��select	�����ѯ
	//lazy��false	�������ؼ�������
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//��������ͨ��һ�������ҵ�һ���������������ԣ�
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��select	�����ѯ
	//lazy��extra	�������裬��������Ч������һ�£����ֻ��ü��ϵ�Size��ֻ��ѯ���ϵ�Size����ʹ��Count��䣩
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//��������ͨ��һ�������ҵ�һ���������������ԣ�
		
		System.out.println(linkMens.size());
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��join	����ѯ
	//lazy��	true|false|extra	ʧЧ����Ϊ��������һ������ˣ����涼�����ټ�����	
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//��������ͨ��һ�������ҵ�һ���������������ԣ�
		
		System.out.println(linkMens.size());
		
		System.out.println(linkMens);

		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��subselect 	�Ӳ�ѯ
	//lazy��	true		������
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql = "from Customer ";
		
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		
		for (Customer c : list) {
			System.out.println(c);
			System.out.println(c.getLinkMens().size());
			System.out.println(c.getLinkMens());
		}

		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��subselect 	�Ӳ�ѯ
	//lazy��	false		�������أ�֮���ӡ��ʱ��Ͳ�����sql����ˣ�
	public void fun6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql = "from Customer ";
		
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		
		for (Customer c : list) {
			System.out.println(c);
			System.out.println(c.getLinkMens().size());
			System.out.println(c.getLinkMens());
		}

		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//���ϼ���Ĺ���
	//fetch��subselect 	�Ӳ�ѯ
	//lazy��	extra		��������
	public void fun7(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		String hql = "from Customer ";
		
		Query query = session.createQuery(hql);
		
		List<Customer> list = query.list();
		
		for (Customer c : list) {
			System.out.println(c);
			System.out.println(c.getLinkMens().size());
			System.out.println(c.getLinkMens());
		}

		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
}
