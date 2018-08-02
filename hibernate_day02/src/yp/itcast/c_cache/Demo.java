package yp.itcast.c_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import yp.itcast.domain.Customer;
import yp.itcast.utils.HibernateUtils;

//测试一级缓存
public class Demo {
	
	@Test
	//证明一级缓存存在
	public void fun1(){
		//1:获得session
		Session session = HibernateUtils.openSession();
		
		//2:控制事务
		Transaction tx = session.beginTransaction();
		
		//3:执行操作
		Customer c1 = session.get(Customer.class, 1l);
		Customer c2 = session.get(Customer.class, 1l);
		Customer c3 = session.get(Customer.class, 1l);
		Customer c4 = session.get(Customer.class, 1l);
		Customer c5 = session.get(Customer.class, 1l);
		System.out.println(c1==c3);//true
		
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
		
		Customer c = session.get(Customer.class, 1l);
		
		c.setCust_name("哈哈");
		//c.setCust_name("微软公司");
		
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
		
		Customer c = new Customer();
		c.setCust_id(1l);//托管/游离
		
		session.update(c);//c1被放入session缓存
		
		/**
		 * （1）执行上面这段代码，可以看出首先设置了Customer对象的id，使之变为游离状态（即数据库中有的状态）
		 * （2）然后执行Update方法，使之变为持久化状态，即将其放入session一级缓存中
		 * （3）接下来再执行session.get（）方法，获取id为1l的对象，这个时候hibernate会去先在session缓存中找
		 * 	       是否有id为1l的Customer，如果有，则直接返回缓存，显然现在有，
		 * （4）然后当提交事务的时候，此时hibernate会对比session缓存和快照（类似于一个集合一样的东西），
		 *     因为此时快照中都没有东西，所以无论如何会打印insert语句
		 */
		Customer c2 = session.get(Customer.class, 1l);
		
		
		//4:提交事务，关闭资源
		tx.commit();
		session.close();//游离/托管，有id，没有关联
		
	}
	
}
