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

//关联级别下的 延迟加载 & 抓取策略
public class Demo {
	
	
	@Test
	//集合级别的关联
	//fetch：select	单表查询
	//lazy：true		使用时才加载集合数据（注意是集合数据）
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//关联级别（通过一个属性找到一个与它关联的属性）
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//集合级别的关联
	//fetch：select	单表查询
	//lazy：false	立即加载集合数据
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//关联级别（通过一个属性找到一个与它关联的属性）
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//集合级别的关联
	//fetch：select	单表查询
	//lazy：extra	极其懒惰，与懒加载效果基本一致，如果只获得集合的Size，只查询集合的Size（会使用Count语句）
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//关联级别（通过一个属性找到一个与它关联的属性）
		
		System.out.println(linkMens.size());
		
		System.out.println(linkMens);
		
		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//集合级别的关联
	//fetch：join	多表查询
	//lazy：	true|false|extra	失效。因为这两个表都一起加载了，后面都不会再加载了	
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------
		Customer c = session.get(Customer.class, 3l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//关联级别（通过一个属性找到一个与它关联的属性）
		
		System.out.println(linkMens.size());
		
		System.out.println(linkMens);

		//---------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//集合级别的关联
	//fetch：subselect 	子查询
	//lazy：	true		懒加载
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
	//集合级别的关联
	//fetch：subselect 	子查询
	//lazy：	false		立即加载（之后打印的时候就不在有sql语句了）
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
	//集合级别的关联
	//fetch：subselect 	子查询
	//lazy：	extra		极其懒惰
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
