package cn.itcast.crm.service;

import cn.itcast.crm.entity.Customer;

public interface CustomerService {
	/**
	 * ����ID��ȡ�ͻ���Ϣ
	 * @param id
	 * @return
	 */
	public Customer findById(Long id);
}
