package yp.itcast.service;

import java.util.List;

import yp.itcast.dao.DeptDao;
import yp.itcast.entity.Department;
import yp.itcast.entity.DeptQuery;

public class DeptService {
	private DeptDao deptDao = new DeptDao();
	
	public List<Department> findAll(){
		return deptDao.findAll();
	}
	
	public List<Department> findByCondition(DeptQuery query){
		return deptDao.findByCondition(query);
	}
}
