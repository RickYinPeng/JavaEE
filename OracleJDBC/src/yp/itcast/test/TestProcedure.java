package yp.itcast.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

/**
 * JAVA���ô洢����
 *    JDBC�Ŀ�������:
 *         1.����������
 *         2.ע������
 *         3.��ȡ����
 *         4.��ȡִ��SQL��statement
 *         5.��װ����
 *         6.ִ��SQL
 *         7.��ȡ���
 *         8.�ͷ���Դ   
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
		//1.ע������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.��ȡ����
		String url = "jdbc:oracle:thin:@192.168.202.129:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.��ȡִ��SQL��statement
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);
		//�����������
		state.setInt(1, 7788);
		//ע���������
		state.registerOutParameter(2,OracleTypes.NUMBER);
	
		//4.ִ��statement
		state.execute();
		
		//5.��ȡִ�н��
		int totalsal = state.getInt(2);
		
		System.out.println("���ʣ�"+totalsal);
	
		//6.�ͷ���Դ
		state.close();
		conn.close();
	}
	
	//���ô洢����
	/*
	 * create or replace function func_getsal(vempno number) return number
		is
 			--����������������н
 			vtotalsal number;
		begin
 			select sal*12+nvl(comm,0) into vtotalsal from emp where empno=vempno;
 			return vtotalsal;
		end;
	 * 
	 * */
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		//1.ע������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.��ȡ����
		String url = "jdbc:oracle:thin:@192.168.202.129:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, username, password);
		//3.��ȡִ��SQL��statement
		String sql ="{?= call func_getsal(?)}";
		CallableStatement state = conn.prepareCall(sql);
		//4.��װ����
		//ע�᷵�����͵Ĳ���
		state.registerOutParameter(1, OracleTypes.NUMBER);
		//���õڶ�������
		state.setInt(2, 7788);
		
		//5.ִ��
		state.execute();
		
		//6.��ȡ���
		int totalsal = state.getInt(1);
		
		System.out.println(totalsal);
		
		//7.�ͷ���Դ
		state.close();
		conn.close();
	}
}













