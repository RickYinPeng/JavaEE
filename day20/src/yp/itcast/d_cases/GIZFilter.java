package yp.itcast.d_cases;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
/**
 * ���ж���ҳ���ݽ���gizpѹ��
 * @author ����
 *
 */
public class GIZFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1������������
		
		
		//����һ��response��װ���߶���
		MyHttpResponse myResponse = new MyHttpResponse((HttpServletResponse) response);
		/**
		 * ����
		 */
		chain.doFilter(request, myResponse);
		
		//3����������Ӧ
		//�õ�ѹ������
		//ע�⣺response������û�з�����ȡʵ�����ݣ���ô�죿
		char[] content = myResponse.getCharArray();
		
		
		System.out.println("###########");
		
		System.out.println(content.toString().getBytes());
		System.out.println(new String(content).getBytes());
		
		System.out.println("###########");
		
		
		//gzipѹ��
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(buf); 
		gzip.write(new String(content).getBytes());
		gzip.finish();
		
		byte[] result = buf.toByteArray();
		//���
		//���������ѹ����ʽ
		myResponse.setHeader("content-encoding", "gzip");
		
		myResponse.getOutputStream().write(result);
		/**
		 * ע�⣺����ʹ����������ˣ���Ϊ����������Ѿ���д����
		 */
		//response.getWriter();
		
	}
}
/**
 * HttpServletResponse��װ������
 */
class MyHttpResponse extends HttpServletResponseWrapper{
	
	private HttpServletResponse response;
	
	//����һ��������������
	private CharArrayWriter charArray = new CharArrayWriter();
	/**
	 * �ṩһ����ȡCharArrayWriter���ݵķ���
	 * 
	 */
	public char[] getCharArray() {
		return charArray.toCharArray();
	}
	
	public MyHttpResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	/**
	 * ��дgetWriter()���������䷵��һ�����л��幦�ܵ�PrintWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		/**
		 * �����Ѿ�������һ����CharArrayWriter����������PrintWriter�ˣ�
		 * ������ǵ��ô�����PrintWriter�����wirter������������ô���ݻ�ֱ��д�뵽CharArrayWriter���������С�
		 */
		
		return new PrintWriter(charArray);
	}
	
}

