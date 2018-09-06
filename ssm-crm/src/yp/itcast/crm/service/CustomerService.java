package yp.itcast.crm.service;

import yp.itcast.common.utils.Page;
import yp.itcast.crm.pojo.Customer;
import yp.itcast.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
}
