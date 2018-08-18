package yp.itcast.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import yp.itcast.dao.EmpDao;
import yp.itcast.entity.Employee;
import yp.itcast.entity.PageBean;

/**
 * 员工的service类
 * @author 鹏鹏
 *
 */
public class EmpService {
	EmpDao empdao = new EmpDao();
	
	public PageBean queryPageBean(String currentPage,String pageSize){
		/***********  1)封装pageBean业务对象     **************/
		
		PageBean pageBean = new PageBean();
		
		//1.1当前页数据
		pageBean.setCurrentPage(Integer.valueOf(currentPage));
		
		
		//1.5总记录数
		pageBean.setTotalCount(empdao.queryCount());
		
		//1.6每页显示记录数
		pageBean.setPageSize(Integer.valueOf(pageSize));
		
		
		List<Employee> list = empdao.queryData(pageBean.getCurrentPage(), pageBean.getPageSize());
		pageBean.setData(list);
		return pageBean;
	}
}
