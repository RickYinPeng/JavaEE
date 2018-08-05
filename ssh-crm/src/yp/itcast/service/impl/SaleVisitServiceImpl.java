package yp.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import yp.itcast.dao.SaleVisitDao;
import yp.itcast.domain.Customer;
import yp.itcast.domain.SaleVisit;
import yp.itcast.service.SaleVisitService;
import yp.itcast.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {
	
	private SaleVisitDao svd;
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		//1.����dao��ѯ�ܼ�¼��
		Integer totalCount  = svd.getTotalCount(dc);

		//2.����pageBean���󣨹��죩
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.����dao��ѯ��ҳ�б�����
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		System.out.println("�ͻ��ݷ��б����ݣ�"+list);
		
		//4.���б����ݷ���pageBean��
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
