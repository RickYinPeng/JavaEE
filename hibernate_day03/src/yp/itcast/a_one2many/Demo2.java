package yp.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.utils.HibernateUtils;

//���Լ�������
public class Demo2 {
	
	@Test
	//����ͻ��Լ��ͻ��µ���ϵ��
	//cascade:save-update
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
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);
		
		//�����һ����ϵ�������ĸ��ͻ�
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(c);
		
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//����ɾ���ͻ�ʱ����ɾ���ͻ��µ���ϵ��
	//cascade:delete
	public void fun2(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
			//��1�������Ҫ�����Ŀͻ�����
			Customer c = session.get(Customer.class,1l);
			//��2��������deleteɾ���ͻ�
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
