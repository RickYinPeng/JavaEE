package yp.itcast.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池版本的jdbcutil
 * @author 鹏鹏
 *
 */
public class JdbcUtil {
	//创建连接池
	private static DataSource cds = new ComboPooledDataSource();
	
	/**
	 * 获取连接池对象
	 */
	public static DataSource getDataSource(){
		//注意：不要这么写，这样会导致我们的连接很快就用完了
		//DataSource cds = new ComboPooledDataSource();
		return cds;
		
	}
		
}
