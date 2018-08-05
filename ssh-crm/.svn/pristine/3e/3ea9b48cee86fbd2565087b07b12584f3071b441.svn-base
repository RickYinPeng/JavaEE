package yp.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import yp.itcast.domain.LinkMan;
import yp.itcast.utils.PageBean;

public interface LinkManService {
	
	//保存联系人
	void save(LinkMan linkMan);
	
	//联系人列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//根据id查询联系人
	LinkMan getById(Long lkm_id);
}
