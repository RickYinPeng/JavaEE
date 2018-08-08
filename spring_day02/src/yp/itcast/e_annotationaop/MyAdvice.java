package yp.itcast.e_annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

//֪ͨ��
@Aspect
//��ʾ������һ��֪ͨ��
public class MyAdvice {
	
	@Pointcut("execution(* yp.itcast.service.*ServiceImpl.*(..))")
	public void pc(){
		
	}
	
	//ǰ��֪ͨ
	//ָ���÷�����ǰ��֪ͨ������ָ�������
	@Before("MyAdvice.pc()")
	public void before(){
		System.out.println("����ǰ��֪ͨ������");	
	}
	
	//����֪ͨ
	@AfterReturning("execution(* yp.itcast.service.*ServiceImpl.*(..))")
	public void afterReturning(){
		System.out.println("���Ǻ���֪ͨ�������쳣�������������");
	}
	
	//����֪ͨ
	@Around("execution(* yp.itcast.service.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ��֣�����");
		
		Object proceed = pjp.proceed();//����Ŀ�귽��
		
		System.out.println("���ǻ���֪֮ͨ��Ĳ��֣�����");
		
		return proceed;
	}
	
	//�쳣֪ͨ
	@AfterThrowing("execution(* yp.itcast.service.*ServiceImpl.*(..))")
	public void afterException(){
		System.out.println("�����ˣ������쳣�ˣ�����");
	}
	
	//����֪ͨ
	@After("execution(* yp.itcast.service.*ServiceImpl.*(..))")
	public void after(){
		System.out.println("����֪ͨ�������쳣Ҳ����ã�");
	}
}
