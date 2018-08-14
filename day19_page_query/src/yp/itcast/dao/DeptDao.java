package yp.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import yp.itcast.entity.Department;
import yp.itcast.entity.DeptQuery;
import yp.itcast.util.JdbcUtil;

public class DeptDao {
	/**
	 * 查询所有部门
	 */
	public List<Department> findAll() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "select * from department";
			List<Department> list = (List<Department>) qr.query(sql, new BeanListHandler(Department.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据条件查询部门
	 * 
	 * @param args
	 */
	public List<Department> findByCondition(DeptQuery query) {
		try {
			// 根据查询条件拼凑一条sql语句
			StringBuffer sql = new StringBuffer("select * from department where 1=1 ");

			if (query != null) {

				// 部门名称不为空，则往sql添加条件
				if (query.getDeptName() != null && !query.getDeptName().trim().equals("")) {
					sql.append(" and deptName like '%" + query.getDeptName() + "%'");
				}

				// 负责人不为空
				if (query.getPrincipal() != null && !query.getPrincipal().trim().equals("")) {
					sql.append(" and principal like '%" + query.getPrincipal() + "%'");
				}

				// 职能
				if (query.getFunctional() != null && !query.getFunctional().trim().equals("")) {
					sql.append(" and functional like '%" + query.getFunctional() + "%'");
				}
			}
			System.out.println(sql.toString());

			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			List<Department> list = (List<Department>) qr.query(sql.toString(), new BeanListHandler(Department.class));

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据id查询部门对象
	 * @param args
	 */
	public Department findById(int id){
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		try {
			return (Department)qr.query("select * from department where id = ?",new BeanHandler(Department.class),new Object[]{id});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		DeptDao d = new DeptDao();
		/*
		 * List<Department> findAll = d.findAll(); for (Department department :
		 * findAll) { System.out.println(department); }
		 */
		DeptQuery query = new DeptQuery();
		query.setDeptName("应用");
		query.setPrincipal("李");
		List<Department> findByCondition = d.findByCondition(query);
		for (Department department : findByCondition) {
			System.out.println(department);
		}

	}
}
