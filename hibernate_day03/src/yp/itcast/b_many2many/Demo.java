package yp.itcast.b_many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.domain.Role;
import yp.itcast.domain.User;
import yp.itcast.utils.HibernateUtils;

//��Զ��ϵ����
public class Demo {
	
	@Test
	//����Ա������ɫ
	public void fun1(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
	//-----------------------------------------------
		//����
		//��1������������User
		User u1 = new User();
		u1.setUser_name("��ǿ��");
		
		User u2 = new User();
		u2.setUser_name("��ҵ�");
		
		//��2������������Role
		Role r1 = new Role();
		r1.setRole_name("����");
		
		Role r2 = new Role();
		r2.setRole_name("����");
		
		//��3�����û�����ϵ
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
		//��4������ɫ����ϵ
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		//��5��������Save����һ���Ա���
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		
	//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//Ϊ��ǿ��������ɫ
	public void fun2(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
	//-----------------------------------------------
		//����
		//��1������ú�ǿ���û�
		User user = session.get(User.class, 1l);
		//��2�����������ؽ�ɫ
		Role r = new Role();
		r.setRole_name("�й���");
		//��3��������ɫ��ӵ��û���
		user.getRoles().add(r);
		//��4��������ɫת��Ϊ�־û�
		//session.save(r);
		
	//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
	@Test
	//Ϊ��ǿ���½����ɫ
	public void fun3(){
		//��1�������session
		Session session = HibernateUtils.openSession();
		//��2������������
		Transaction tx = session.beginTransaction();
	//-----------------------------------------------
		//����
		//��1������ú�ǿ���û�
		User user = session.get(User.class, 1l);
		//��2�������Ҫ�����Ľ�ɫ���󣨱��࣬������
		Role r1 = session.get(Role.class, 1l);
		Role r2 = session.get(Role.class, 2l);
		//��3��������ɫ���û��Ľ�ɫ�������Ƴ�
		user.getRoles().remove(r1);
		user.getRoles().remove(r2);
		
	//-----------------------------------------------
		//��4�����ύ����
		tx.commit();
		//��5�����ر���Դ
		session.close();
	}
	
}
