package yp.itcast.b_state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试对象的三种状态
public class Demo {
	
	@Test
	//查看三种状态
	public void fun1(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		Customer c = new Customer();//没有id，没有与session关联---->瞬时状态
		
		c.setCust_name("联想");//瞬时状态
		
		session.save(c);//持久化状态，有id，有关联
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//三种状态的特点
	//save方法：其实不能理解成保存。理解成将瞬时状态转换成持久状态的方法
	//主键自增：执行save方法时，为了将对象转换为持久化状态，必须生成id值。所以需要执行insert语句生成
	//increment:执行save方法，为了生成id，会执行查询id最大值的sql语句
	public void fun2(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		Customer c = new Customer();//没有id，没有与session关联---->瞬时状态
		
		c.setCust_name("联想");//瞬时状态
		
		session.save(c);//持久化状态，有id，有关联
		//打断点观察，发现上面这一句一执行，就在控制台打印了insert语句（明明不就是保存吗），其实不是，是为了生成id
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
	@Test
	//三种状态的特点
	//持久化状态特点：持久化状态对象的任何变化都会自动同步到数据库中
	public void fun3(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		Customer c = session.get(Customer.class, 1l);//持久化装袋
		
		c.setCust_name("微软公司");
		
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
}
