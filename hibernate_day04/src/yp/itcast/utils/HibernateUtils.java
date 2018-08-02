package yp.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.Main;

public class HibernateUtils {
	
	private static SessionFactory sf = null;
	
	//类的话是由类加载器加载的，类加载器是有一个缓存区，它会把读取到的类缓存起来，
	//		再一次虚拟机运行期间，一个类只会被加载一次，这样的话，静态代码块指挥被运行一次
	static{
		//1 ：创建，调用空参构造+2:读取指定配置文件--->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
	
		//2：根据配置信息，创建SessionFactory对象；
		sf = conf.buildSessionFactory();
	}
	
	//获得sesion ---->获得全新session
	public static Session openSession(){

		//3:获得session
		Session session = sf.openSession();
		return session;
	}
	
	//获得session ---->获得与线程绑定的sesion
	public static Session getCurrentSession(){
	
		//3:获得session
		Session session = sf.getCurrentSession();
		return session;
	}
	
	public static void main(String[] args) {
		System.out.println(HibernateUtils.openSession());
	}
}
