package yp.itcast.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yp.itcast.common.utils.Page;
import yp.itcast.crm.mapper.CustomerDao;
import yp.itcast.crm.pojo.Customer;
import yp.itcast.crm.pojo.QueryVo;
import yp.itcast.crm.service.CustomerService;
/**
 * 客户管理
 * @author 鹏鹏
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	//通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//每页显示5条
		page.setSize(vo.getSize());
		if(null != vo){
			//判断当前页
			if(null!=vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(null!=vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null!=vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null!=vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null!=vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;	
	}
	
}
