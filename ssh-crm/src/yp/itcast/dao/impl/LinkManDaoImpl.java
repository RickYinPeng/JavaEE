package yp.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import yp.itcast.dao.LinkManDao;
import yp.itcast.domain.LinkMan;
@Repository("linkManDao")
public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao{
	//�м�������
	@Resource(name="sessionFactory")
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
}
