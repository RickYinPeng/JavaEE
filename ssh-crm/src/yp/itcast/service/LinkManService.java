package yp.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import yp.itcast.domain.LinkMan;
import yp.itcast.utils.PageBean;

public interface LinkManService {
	
	//������ϵ��
	void save(LinkMan linkMan);
	
	//��ϵ���б�
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//����id��ѯ��ϵ��
	LinkMan getById(Long lkm_id);
}
