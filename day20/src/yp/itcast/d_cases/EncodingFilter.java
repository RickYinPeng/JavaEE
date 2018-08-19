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
 * 参数中文乱码问题的过滤器
 * @author 鹏鹏
 *
 */
public class EncodingFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * 执行过滤任务
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		
		/**
		 * post提交参数
		 */
		request.setCharacterEncoding("utf-8");
		
		//创建一个HttpServletRequest实现类的装饰者类，重写getParameter方法
		
		HttpServletRequest myHttpRequest = new MyHttpRequest(request);
		
		/**
		 * 注意：这里放行的是装饰后的HttpServletRequest，这样在业务的servlet调用getParameter才是新的重写后的方法
		 *
		 */
		chain.doFilter(myHttpRequest, resp);
	}
	

}

/**
 * 装饰者类
 * @author 鹏鹏
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
		 * 对Get提交参数处理
		 */
		//1):得到原来的参数
		String value = request.getParameter(name);
		
		//2）：手动解码
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

