package cn.itcast.crm.dao;

import cn.itcast.crm.entity.Customer;

public interface CustomerDao {
	
	/**
	 * ����ID��ȡ�ͻ���Ϣ
	 * @param id
	 * @return
	 */
	public Customer findById(Long id);
	
}
