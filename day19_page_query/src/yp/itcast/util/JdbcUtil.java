package yp.itcast.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ӳذ汾��jdbcutil
 * @author ����
 *
 */
public class JdbcUtil {
	//�������ӳ�
	private static DataSource cds = new ComboPooledDataSource();
	
	/**
	 * ��ȡ���ӳض���
	 */
	public static DataSource getDataSource(){
		//ע�⣺��Ҫ��ôд�������ᵼ�����ǵ����Ӻܿ��������
		//DataSource cds = new ComboPooledDataSource();
		return cds;
		
	}
		
}
