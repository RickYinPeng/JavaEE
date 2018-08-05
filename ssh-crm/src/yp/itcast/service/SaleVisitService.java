package yp.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import yp.itcast.domain.SaleVisit;
import yp.itcast.utils.PageBean;

public interface SaleVisitService {
	
	//保存客户拜访记录
	void save(SaleVisit saleVisit);
	
	//客户拜访记录分页列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	
	//根据id获得拜访记录对象
	SaleVisit getById(String visit_id);
}
