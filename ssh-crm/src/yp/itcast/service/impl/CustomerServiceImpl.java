package yp.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import yp.itcast.dao.CustomerDao;
import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.service.CustomerService;
import yp.itcast.utils.PageBean;
@Service("customerService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl implements CustomerService {
	
	@Resource(name="customerDao")
	private CustomerDao cd;

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		//1.调用dao查询总记录数
		Integer totalCount  = cd.getTotalCount(dc);

		//2.创建pageBean对象（构造）
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.调用dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		System.out.println("客户列表数据："+list);
		
		//4.将列表数据放入pageBean中
		pb.setList(list);
		
		return pb;
	}
	public void save(Customer customer) {
		//1.维护Customer与数据字典对象关系，由于struts2参数封装，会将参数封装到数据字典的id属性
		//那么我们无需手动维护关系
		//（技巧）调用Dao取出数据字典对象，将数据字典设置到Customer对象对应的属性中
		//2.调用dao保存客户
		System.out.println("保存客户Service："+customer);
		
		cd.saveOrUpdate(customer);
		
		
	}
	public Customer getById(Long cust_id) {
		
		return cd.getById(cust_id);
	}
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	public List<Object[]> getIndustryCount() {
		return cd.getIndustryCount();
	}

}
