package yp.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yp.itcast.dao.CustomerDao;
import yp.itcast.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

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
