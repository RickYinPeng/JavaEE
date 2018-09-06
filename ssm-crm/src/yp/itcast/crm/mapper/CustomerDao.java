package yp.itcast.crm.mapper;

import java.util.List;

import yp.itcast.crm.pojo.BaseDict;
import yp.itcast.crm.pojo.Customer;
import yp.itcast.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//查询总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
}
