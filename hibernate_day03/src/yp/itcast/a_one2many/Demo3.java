package yp.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.utils.HibernateUtils;

//��������---��ϵά��
public class Demo3 {
	
	@Test
	//����ͻ��Լ��ͻ��µ���ϵ��
	public void fun1(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
		Customer c = new Customer();
		c.setCust_name("���ǲ���");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("�����");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("���ö�");
		
		//���һ�Զ࣬�ͻ����ж����ϵ��
		//customer�Ѿ���ά����ϵ�ˣ������������д��벻��Ҫ��
/*		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);*/
		
		//�����һ����ϵ�������ĸ��ͻ�
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(c);
		session.save(lm1);
		session.save(lm2);
		
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//ɾ���ͻ�
	public void fun2(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
		Customer c = session.get(Customer.class, 1l);
			
		session.delete(c);
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//������ϵ���Լ���ϵ�˶�Ӧ�Ŀͻ�
	//cascade:save-update
	public void fun3(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
			Customer c = new Customer();
			c.setCust_name("��������");
			
			LinkMan lm1 = new LinkMan();
			lm1.setLkm_name("����");
			
			c.getLinkMens().add(lm1);
			
			lm1.setCustomer(c);
			
			session.save(lm1);
		
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
}
