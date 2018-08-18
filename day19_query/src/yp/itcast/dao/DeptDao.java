package yp.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import yp.itcast.entity.Department;
import yp.itcast.entity.DeptQuery;
import yp.itcast.util.JdbcUtil;

public class DeptDao {
	/**
	 * ��ѯ���в���
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
	 * ����������ѯ����
	 * 
	 * @param args
	 */
	public List<Department> findByCondition(DeptQuery query) {
		try {
			// ���ݲ�ѯ����ƴ��һ��sql���
			StringBuffer sql = new StringBuffer("select * from department where 1=1 ");

			if (query != null) {

				// �������Ʋ�Ϊ�գ�����sql�������
				if (query.getDeptName() != null && !query.getDeptName().trim().equals("")) {
					sql.append(" and deptName like '%" + query.getDeptName() + "%'");
				}

				// �����˲�Ϊ��
				if (query.getPrincipal() != null && !query.getPrincipal().trim().equals("")) {
					sql.append(" and principal like '%" + query.getPrincipal() + "%'");
				}

				// ְ��
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

	public static void main(String[] args) {
		DeptDao d = new DeptDao();
		/*
		 * List<Department> findAll = d.findAll(); for (Department department :
		 * findAll) { System.out.println(department); }
		 */
		DeptQuery query = new DeptQuery();
		query.setDeptName("Ӧ��");
		query.setPrincipal("��");
		List<Department> findByCondition = d.findByCondition(query);
		for (Department department : findByCondition) {
			System.out.println(department);
		}

	}
}
