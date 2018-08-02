package yp.itcast.a_HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//ѧϰHQL�﷨(������)----����ѯ�﷨
public class Demo2 {
	//�ع�--ԭ��SQL
	//��������--�ѿ����������⣩
//		select * from A,B
	//������
//		|-��ʽ������
//			select * from A,B where b.aid=a.id;(�ڽ������ӻ����ϼ���where������������Щ����Ҫ�Ľ��)
//		|-��ʾ������
//			select * from A inner join B on b.aid=a.id;
	//������
//		|-����
//			select * from A left join B on b.aid=a.id;
//		|-����
//			select * from A right join B on b.aid=a.id;
//---------------------------------------------------------------------------
//HQL�Ķ���ѯ
	//�����ӣ����У�
	//������
//		|-���⣨���У�
//		|-���⣨���У�
		
		//������
		@Test
		public void fun1(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c inner join c.linkMens ";//c�൱�ڱ���
			
			Query query = session.createQuery(hql);
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				System.out.println(Arrays.toString(objects));
			}
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL ����������(��fetch)=>�����ǽ��з�װ������ֵ����һ������
		@Test
		public void fun2(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c inner join fetch c.linkMens ";//c�൱�ڱ���
			
			Query query = session.createQuery(hql);
			List<Customer> list = query.list();
			
			System.out.println(list);
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL ��������=>�����ӵ����˷ֱ𷵻أ��ŵ�������
		@Test
		public void fun3(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c left join  c.linkMens ";//c�൱�ڱ���
			
			Query query = session.createQuery(hql);
			
			List<Object[]> list = query.list();
			
			for (Object[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}
			
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL ��������=>�����ӵ����˷ֱ𷵻أ��ŵ�������
		@Test
		public void fun4(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c right join  c.linkMens ";//c�൱�ڱ���
			
			Query query = session.createQuery(hql);
			
			List<Object[]> list = query.list();
			
			for (Object[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
}
