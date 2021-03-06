package yp.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import yp.itcast.dao.SaleVisitDao;
import yp.itcast.domain.Customer;
import yp.itcast.domain.SaleVisit;
import yp.itcast.service.SaleVisitService;
import yp.itcast.utils.PageBean;
@Service("saleVisitService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class SaleVisitServiceImpl implements SaleVisitService {
	@Resource(name="saleVisitDao")
	private SaleVisitDao svd;
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		//1.调用dao查询总记录数
		Integer totalCount  = svd.getTotalCount(dc);

		//2.创建pageBean对象（构造）
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.调用dao查询分页列表数据
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		System.out.println("客户拜访列表数据："+list);
		
		//4.将列表数据放入pageBean中
		pb.setList(list);
		
		return pb;
	}
	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}
	
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);
	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}



}
