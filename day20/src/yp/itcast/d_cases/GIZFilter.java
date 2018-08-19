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
 * 集中对网页内容进行gizp压缩
 * @author 鹏鹏
 *
 */
public class GIZFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1）：过滤请求
		
		
		//创建一个response的装饰者对象
		MyHttpResponse myResponse = new MyHttpResponse((HttpServletResponse) response);
		/**
		 * 放行
		 */
		chain.doFilter(request, myResponse);
		
		//3）：过滤响应
		//得到压缩内容
		//注意：response对象中没有方法获取实体内容，怎么办？
		char[] content = myResponse.getCharArray();
		
		
		System.out.println("###########");
		
		System.out.println(content.toString().getBytes());
		System.out.println(new String(content).getBytes());
		
		System.out.println("###########");
		
		
		//gzip压缩
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(buf); 
		gzip.write(new String(content).getBytes());
		gzip.finish();
		
		byte[] result = buf.toByteArray();
		//输出
		//告诉浏览器压缩格式
		myResponse.setHeader("content-encoding", "gzip");
		
		myResponse.getOutputStream().write(result);
		/**
		 * 注意：不能使用下面这个了，因为下面这个我已经重写过了
		 */
		//response.getWriter();
		
	}
}
/**
 * HttpServletResponse的装饰者类
 */
class MyHttpResponse extends HttpServletResponseWrapper{
	
	private HttpServletResponse response;
	
	//定义一个缓存容器对象
	private CharArrayWriter charArray = new CharArrayWriter();
	/**
	 * 提供一个获取CharArrayWriter内容的方法
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
	 * 重写getWriter()方法，让其返回一个带有缓冲功能的PrintWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		/**
		 * 现在已经创建了一个带CharArrayWriter缓存容器的PrintWriter了，
		 * 如果我们调用带缓存PrintWriter对象的wirter（）方法，那么内容会直接写入到CharArrayWriter缓存容器中。
		 */
		
		return new PrintWriter(charArray);
	}
	
}

