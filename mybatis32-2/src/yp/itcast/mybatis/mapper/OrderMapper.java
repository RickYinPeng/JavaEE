package yp.itcast.mybatis.mapper;

import java.util.List;

import yp.itcast.mybatis.pojo.Orders;

public interface OrderMapper {
	
	//��ѯ������������
	public List<Orders> selectOrdersList();
	
	//һ��һ������ѯ,�Զ���Ϊ���Ĺ����û�
	public List<Orders> selectOrders();
	
}
