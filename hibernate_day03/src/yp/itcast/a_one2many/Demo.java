package yp.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.utils.HibernateUtils;

//һ�Զ�|���һ��ϵ
public class Demo {
	
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
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);
		
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
	//�ͻ�������ϵ��
	public void fun2(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
			//��1�������Ҫ�����Ŀͻ�����
			Customer c = session.get(Customer.class,5l);
			//��2����������ϵ��
			LinkMan lm = new LinkMan();
			lm.setLkm_name("��ǿ��");
			//��3��������ϵ����ӵ��ͻ������ͻ����õ���ϵ����
			c.getLinkMens().add(lm);
			lm.setCustomer(c);
			//��4����ִ�б���
			session.save(lm);
		
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//Ϊ�ͻ�ɾ����ϵ��
	public void fun3(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
		//-----------------------------------------------
		//��3��������
			//��1�������Ҫ�����Ŀͻ�����
			Customer c = session.get(Customer.class,5l);
			//��2�������Ҫ�Ƴ�����ϵ��
			LinkMan lm = session.get(LinkMan.class, 4l);
			//��3��������ϵ�˴ӿͻ����Ƴ���
			c.getLinkMens().remove(lm);
			lm.setCustomer(null);
			//���ǳ־û�״̬
		
		//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
}
