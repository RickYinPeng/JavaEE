package yp.itcast.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yp.itcast.entity.Department;
import yp.itcast.entity.EmpQuery;
import yp.itcast.entity.Employee;
import yp.itcast.util.JdbcUtil;

/**
 * 员工的dao
 * 
 * @author 鹏鹏
 *
 */
public class EmpDao {

	DeptDao deptdao = new DeptDao();

	/**
	 * 提供一个查询当前页员工数据的方法
	 */
	public List<Employee> queryData(int currentPage, int pageSize, EmpQuery query) {
		try {
			// 1）创建QueryRunner
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

			// 分页+条件查询的sql
			StringBuffer sql = new StringBuffer("SELECT * FROM employee where 1=1 ");

			if (query != null) {

				if (query.getName() != null && !query.getName().trim().equals("")) {
					sql.append(" and name like '%" + query.getName() + "%' ");
				}
				if (query.getGender() != null && !query.getGender().trim().equals("")) {
					sql.append(" and gender like '%" + query.getGender() + "%' ");
				}
				if (query.getTitle() != null && !query.getTitle().trim().equals("")) {
					sql.append(" and title like '%" + query.getTitle() + "%' ");
				}
				if (query.getEmail() != null && !query.getEmail().trim().equals("")) {
					sql.append(" and email like '%" + query.getEmail() + "%' ");
				}
				// 如果薪水值不为空，则查询的结果应该大于起始薪水值
				if (query.getBeginSalary() != 0) {
					sql.append(" and salary>='" + query.getBeginSalary() + "'");
				}
				if (query.getEndSalary() != 0) {
					sql.append(" and salary<='" + query.getEndSalary() + "'");
				}
				// 部门
				if (query.getDeptId() != 0) {
					sql.append(" and deptId=" + query.getDeptId() + "");
				}
			}
			// 分页
			sql.append(" limit ?,?");
			System.out.println(sql.toString());

			// 起始行
			int satrtNo = (currentPage - 1) * pageSize;
			List<Employee> list = (List<Employee>) qr.query(sql.toString(), new MyEmpResultSetHandler(),
					new Object[] { satrtNo, pageSize });
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 自行封装结果集
	 */
	class MyEmpResultSetHandler implements ResultSetHandler {

		public Object handle(ResultSet rs) throws SQLException {
			List<Employee> list = new ArrayList<Employee>();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setGender(rs.getString("gender"));
				emp.setTitle(rs.getString("title"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));

				// 部门id
				int id = rs.getInt("deptId");

				// 根据id查询部门对象
				Department department = deptdao.findById(id);

				emp.setDept(department);
				list.add(emp);
			}
			return list;
		}
	}

	/**
	 * 提供一个查询总记录数的方法
	 * 
	 * @param args
	 */
	public int queryCount(EmpQuery query) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			// String sql = "SELECT COUNT(*) FROM employee";
			StringBuffer sql = new StringBuffer("SELECT count(*) FROM employee where 1=1 ");

			if (query != null) {
				if (query.getName() != null && !query.getName().trim().equals("")) {
					sql.append(" and name like '%" + query.getName() + "%' ");
				}
				if (query.getGender() != null && !query.getGender().trim().equals("")) {
					sql.append(" and gender like '%" + query.getGender() + "%' ");
				}
				if (query.getTitle() != null && !query.getTitle().trim().equals("")) {
					sql.append(" and title like '%" + query.getTitle() + "%' ");
				}
				if (query.getEmail() != null && !query.getEmail().trim().equals("")) {
					sql.append(" and email like '%" + query.getEmail() + "%' ");
				}
				// 如果薪水值不为空，则查询的结果应该大于起始薪水值
				if (query.getBeginSalary() != 0) {
					sql.append(" and salary>='" + query.getBeginSalary() + "'");
				}
				if (query.getEndSalary() != 0) {
					sql.append(" and salary<='" + query.getEndSalary() + "'");
				}
				// 部门
				if (query.getDeptId() != 0) {
					sql.append(" and deptId=" + query.getDeptId() + "");
				}
			}
			System.out.println(sql.toString());

			Long count = (Long) qr.query(sql.toString(), new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
/*		List<Employee> list = dao.queryData(1, 2);
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		EmpQuery query = new EmpQuery();
/*		query.setName("1");
		List<Employee> list = dao.queryData(1, 2, query);
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		query.setName("1");
		int count = dao.queryCount(query);
		System.out.println(count);
	}
}
