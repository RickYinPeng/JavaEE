package yp.itcast.crm.mapper;

import java.util.List;

import yp.itcast.crm.pojo.BaseDict;
import yp.itcast.crm.pojo.Customer;
import yp.itcast.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//��ѯ������
	public Integer customerCountByQueryVo(QueryVo vo);
	
	//�����
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
}
