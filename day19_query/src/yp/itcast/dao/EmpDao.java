package yp.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yp.itcast.entity.Employee;
import yp.itcast.util.JdbcUtil;

/**
 * Ա����dao
 * @author ����
 *
 */
public class EmpDao {
	
	/**
	 * �ṩһ����ѯ��ǰҳԱ�����ݵķ���
	 */
	public List<Employee> queryData(int currentPage,int pageSize){
		try {
			//1������QueryRunner
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			//��ѯ��ǰҳ��sql
			//SELECT * FROM employee ��LIMIT ��ǰҳҳ��-1��*ÿҳ��ʾ�ļ�¼��,2;
			String sql = "SELECT * FROM employee limit ?,?";
			//��ʼ��
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
	 * �ṩһ����ѯ�ܼ�¼���ķ���
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
