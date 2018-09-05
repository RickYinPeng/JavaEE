package yp.itcast.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

/**
 * JAVA调用存储过程
 *    JDBC的开发步骤:
 *         1.导入驱动包
 *         2.注册驱动
 *         3.获取连接
 *         4.获取执行SQL的statement
 *         5.封装参数
 *         6.执行SQL
 *         7.获取结果
 *         8.释放资源   
 * 
 *
 */


public class TestProcedure {
	@Test
	/*
	 * create or replace procedure proc_gettotalsal(vempno in number,vtotalsal out number)
		is
		begin
  			select sal*12+nvl(comm,0) into vtotalsal from emp where empno = vempno;
		end;
	 * */
	public void test1() throws ClassNotFoundException, SQLException{
		//1.注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:oracle:thin:@192.168.202.129:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.获取执行SQL的statement
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);
		//设置输入参数
		state.setInt(1, 7788);
		//注册输出参数
		state.registerOutParameter(2,OracleTypes.NUMBER);
	
		//4.执行statement
		state.execute();
		
		//5.获取执行结果
		int totalsal = state.getInt(2);
		
		System.out.println("工资："+totalsal);
	
		//6.释放资源
		state.close();
		conn.close();
	}
	
	//调用存储函数
	/*
	 * create or replace function func_getsal(vempno number) return number
		is
 			--声明变量，保存年薪
 			vtotalsal number;
		begin
 			select sal*12+nvl(comm,0) into vtotalsal from emp where empno=vempno;
 			return vtotalsal;
		end;
	 * 
	 * */
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		//1.注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接
		String url = "jdbc:oracle:thin:@192.168.202.129:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, username, password);
		//3.获取执行SQL的statement
		String sql ="{?= call func_getsal(?)}";
		CallableStatement state = conn.prepareCall(sql);
		//4.封装参数
		//注册返回类型的参数
		state.registerOutParameter(1, OracleTypes.NUMBER);
		//设置第二个参数
		state.setInt(2, 7788);
		
		//5.执行
		state.execute();
		
		//6.获取结果
		int totalsal = state.getInt(1);
		
		System.out.println(totalsal);
		
		//7.释放资源
		state.close();
		conn.close();
	}
}













