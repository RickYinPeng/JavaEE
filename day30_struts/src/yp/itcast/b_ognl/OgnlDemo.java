package yp.itcast.b_ognl;

import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

//Ŀ�꣺ѧϰ�˽�Ognl���ʽ�ĺ��Ķ���OgnlContext�����ʹ��
public class OgnlDemo {

	@Test
	public void test1() {
		User user = new User();
		user.setName("eric");
		user.setAge(20);

		// 1):����һ��OgnlContext����
		OgnlContext context = new OgnlContext();

		// 2):��user�������OgnlContext����
		context.put("user", user);

		// 3):��OgnlContext����ȡ������
		User user2 = (User) context.get("user");

		System.out.println(user2.getName() + "---" + user2.getAge());
	}

	// ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����ǷǸ�������ô����Ҫʹ��#��ȥȡ���涨��
	@Test
	public void test2() throws Exception {
		User user = new User();
		user.setName("eric");
		user.setAge(20);

		// 1):����һ��OgnlContext����
		OgnlContext context = new OgnlContext();

		// 2):��user�������OgnlContext����
		context.put("user", user);// ��OgnlContext�ķǸ����������

		// ʹ��ognl���ʽ��OgnlContext����ȡ������
		Object ognlObj = Ognl.parseExpression("#user.name");// ���ʽ����
		String name = (String) Ognl.getValue(ognlObj, context, context.getRoot());// ��ȡ���ݷ���
		System.out.println(name);

	}

	// ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����Ǹ�������ô����Ҫʹ��#��ȥȡ������Ҫһ��key���ƣ�ֱ��д�����������Լ���
	@Test
	public void test3() throws Exception {
		User user = new User();
		user.setName("eric");
		user.setAge(20);
		// 1):����һ��OgnlContext����
		OgnlContext context = new OgnlContext();

		// 2):��user�������OgnlContext����
		context.setRoot(user);// ��OgnlContext�ĸ����������

		// ʹ��ognl���ʽ��OgnlContext����ȡ������ 
		Object ognlObj = Ognl.parseExpression("name");// ���ʽ����
		String name = (String) Ognl.getValue(ognlObj, context, context.getRoot());// ��ȡ���ݷ���
		System.out.println(name);

	}

	
	/**
	 * java.util.Math
	 * Math.rount(10.3) :�������뷽��
	 * ʹ��Ognl���ʽ����
	 * @throws Exception
	 */
	// Ognl���ʽ���þ�̬����
	@Test
	public void test4() throws Exception {
		// 1):����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		// ʹ��ognl���ʽ��OgnlContext����ȡ������
		Object ognlObj = Ognl.parseExpression("@java.lang.Math@round(10.5)");// ���ʽ����
		Object result =  Ognl.getValue(ognlObj, context, context.getRoot());// ��ȡ���ݷ���
		System.out.println(result);

	}

}
