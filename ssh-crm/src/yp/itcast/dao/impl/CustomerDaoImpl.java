package yp.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import yp.itcast.dao.CustomerDao;
import yp.itcast.domain.Customer;
@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	
	//有技术含量
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	
	@SuppressWarnings("all")
	public List<Object[]> getIndustryCount() {
		//使用原生SQL查询
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException {
				
			String sql = "SELECT dict_item_name,COUNT(*) "+ 
								"FROM cst_customer,base_dict "+
								"WHERE cst_customer.cust_industry=base_dict.dict_id "+
								"GROUP BY cst_customer.cust_industry;";
				
				SQLQuery query = session.createSQLQuery(sql);
				
				return query.list();
			}
		});
		
		return list;
	}

/*	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		
		List<Long> list= (List<Long>) getHibernateTemplate().findByCriteria(dc);
		
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}

	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		
		//人家封装好的分页查询（spring为咱们封装好的一个方法，体贴）
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize );
		
		
		return list;
	}*/

}
