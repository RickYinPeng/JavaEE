package yp.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import yp.itcast.domain.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	
	/*//根据条件查询总记录数
	Integer getTotalCount(DetachedCriteria dc);

	//查询
	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);*/

}
