package yp.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yp.itcast.entity.Employee;
import yp.itcast.util.JdbcUtil;

/**
 * 员工的dao
 * @author 鹏鹏
 *
 */
public class EmpDao {
	
	/**
	 * 提供一个查询当前页员工数据的方法
	 */
	public List<Employee> queryData(int currentPage,int pageSize){
		try {
			//1）创建QueryRunner
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			//查询当前页的sql
			//SELECT * FROM employee （LIMIT 当前页页码-1）*每页显示的记录数,2;
			String sql = "SELECT * FROM employee limit ?,?";
			//起始行
			int satrtNo = (currentPage-1)*pageSize;
			List<Employee> list = (List<Employee>) qr.query(sql, new BeanListHandler(Employee.class), new Object[]{satrtNo,pageSize});
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 提供一个查询总记录数的方法
	 * @param args
	 */
	public int queryCount(){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "SELECT COUNT(*) FROM employee";
			Long count = (Long) qr.query(sql, new ScalarHandler());
			return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		List<Employee> list = dao.queryData(1, 2);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
}
