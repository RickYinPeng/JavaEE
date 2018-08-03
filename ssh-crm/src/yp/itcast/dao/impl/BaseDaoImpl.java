package yp.itcast.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import yp.itcast.dao.BaseDao;
import yp.itcast.domain.Customer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//���ڽ�������ʱ�ڵķ�������
	
	public BaseDaoImpl() {
		//��õ�ǰ���͵Ĵ��з������͵ĸ���
		ParameterizedType ptclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		//��������ڵķ�������
		clazz = (Class) ptclass.getActualTypeArguments()[0];
	
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	public void delete(Serializable id) {
		T t = this.getById(id);//��ȡ
		getHibernateTemplate().delete(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	public T getById(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public Integer getTotalCount(DetachedCriteria dc) {
		//���ò�ѯ�ľۺϺ������ܼ�¼��
		dc.setProjection(Projections.rowCount());
				
		List<Long> list= (List<Long>) getHibernateTemplate().findByCriteria(dc);
				
		//���֮ǰ���õľۺϺ���
		dc.setProjection(null);
				
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}

	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		//�˼ҷ�װ�õķ�ҳ��ѯ��springΪ���Ƿ�װ�õ�һ��������������
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize );
				
		return list;
	
	}

	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}


}
