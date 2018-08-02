package yp.itcast.a_HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//学习HQL语法(不常用)----多表查询语法
public class Demo2 {
	//回顾--原生SQL
	//交叉连接--笛卡尔积（避免）
//		select * from A,B
	//内连接
//		|-隐式内连接
//			select * from A,B where b.aid=a.id;(在交叉连接基础上加上where条件，过滤那些不必要的结果)
//		|-显示内连接
//			select * from A inner join B on b.aid=a.id;
	//外连接
//		|-左外
//			select * from A left join B on b.aid=a.id;
//		|-右外
//			select * from A right join B on b.aid=a.id;
//---------------------------------------------------------------------------
//HQL的多表查询
	//内连接（迫切）
	//外连接
//		|-左外（迫切）
//		|-右外（迫切）
		
		//内连接
		@Test
		public void fun1(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c inner join c.linkMens ";//c相当于别名
			
			Query query = session.createQuery(hql);
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				System.out.println(Arrays.toString(objects));
			}
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL 迫切内连接(加fetch)=>帮我们进行封装，返回值就是一个对象
		@Test
		public void fun2(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c inner join fetch c.linkMens ";//c相当于别名
			
			Query query = session.createQuery(hql);
			List<Customer> list = query.list();
			
			System.out.println(list);
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL 左外连接=>将连接的两端分别返回，放到数组中
		@Test
		public void fun3(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c left join  c.linkMens ";//c相当于别名
			
			Query query = session.createQuery(hql);
			
			List<Object[]> list = query.list();
			
			for (Object[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}
			
			
			//---------------------------------------------------
			tx.commit();
			session.close();
		}
		
		//HQL 右外连接=>将连接的两端分别返回，放到数组中
		@Test
		public void fun4(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//---------------------------------------------------
			String hql = "from Customer c right join  c.linkMens ";//c相当于别名
			
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
