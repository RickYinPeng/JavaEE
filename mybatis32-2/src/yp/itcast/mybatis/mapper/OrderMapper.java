package yp.itcast.mybatis.mapper;

import java.util.List;

import yp.itcast.mybatis.pojo.Orders;

public interface OrderMapper {
	
	//查询订单所有数据
	public List<Orders> selectOrdersList();
	
	//一对一关联查询,以订单为中心关联用户
	public List<Orders> selectOrders();
	
}
