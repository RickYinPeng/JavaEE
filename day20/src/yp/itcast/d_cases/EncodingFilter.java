package yp.itcast.d_cases;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * ����������������Ĺ�����
 * @author ����
 *
 */
public class EncodingFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * ִ�й�������
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//ǿ��ת��
		HttpServletRequest request = (HttpServletRequest) req;
		
		/**
		 * post�ύ����
		 */
		request.setCharacterEncoding("utf-8");
		
		//����һ��HttpServletRequestʵ�����װ�����࣬��дgetParameter����
		
		HttpServletRequest myHttpRequest = new MyHttpRequest(request);
		
		/**
		 * ע�⣺������е���װ�κ��HttpServletRequest��������ҵ���servlet����getParameter�����µ���д��ķ���
		 *
		 */
		chain.doFilter(myHttpRequest, resp);
	}
	

}

/**
 * װ������
 * @author ����
 *
 */
class MyHttpRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	
	public MyHttpRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		/**
		 * ��Get�ύ��������
		 */
		//1):�õ�ԭ���Ĳ���
		String value = request.getParameter(name);
		
		//2�����ֶ�����
		if("Get".equals(request.getMethod())){
			try {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return value;
	}
}

