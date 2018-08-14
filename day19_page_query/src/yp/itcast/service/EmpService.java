package yp.itcast.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import yp.itcast.dao.DeptDao;
import yp.itcast.dao.EmpDao;
import yp.itcast.entity.EmpQuery;
import yp.itcast.entity.Employee;
import yp.itcast.entity.PageBean;

/**
 * Ա����service��
 * @author ����
 *
 */
public class EmpService {
	EmpDao empdao = new EmpDao();
	public PageBean queryPageBean(String currentPage,String pageSize,EmpQuery query){
		/***********  1)��װpageBeanҵ�����     **************/
		
		PageBean pageBean = new PageBean();
		
		//1.1��ǰҳ����
		pageBean.setCurrentPage(Integer.valueOf(currentPage));
		
		
		//1.5�ܼ�¼��
		pageBean.setTotalCount(empdao.queryCount(query));
		
		//1.6ÿҳ��ʾ��¼��
		pageBean.setPageSize(Integer.valueOf(pageSize));
		
		
		List<Employee> list = empdao.queryData(pageBean.getCurrentPage(), pageBean.getPageSize(),query);
		pageBean.setData(list);
		return pageBean;
	}
}
