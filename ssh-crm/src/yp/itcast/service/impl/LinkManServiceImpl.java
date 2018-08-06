package yp.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import yp.itcast.dao.LinkManDao;
import yp.itcast.domain.Customer;
import yp.itcast.domain.LinkMan;
import yp.itcast.service.LinkManService;
import yp.itcast.utils.PageBean;
@Service("linkManService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class LinkManServiceImpl implements LinkManService {
	
	@Resource(name="linkManDao")
	private LinkManDao lmd;
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		//1.调用dao查询总记录数
		Integer totalCount  = lmd.getTotalCount(dc);

		//2.创建pageBean对象（构造）
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.调用dao查询分页列表数据
		List<LinkMan> list = lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		System.out.println("联系人列表数据："+list);
		
		//4.将列表数据放入pageBean中
		pb.setList(list);
		
		return pb;
	}
	public LinkMan getById(Long lkm_id) {
		
		return lmd.getById(lkm_id);
	}
	
	
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}



}
