package yp.itcast.d_cases;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2）：执行目标代码
		// t1(response);
		// 准备内容
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 3000; i++) {
			sb.append("abcd");
		}
		/**
		 * 注意：每次写出的网页内容都是已经经过gizp压缩的内容
		 */
		response.getWriter().write(sb.toString());
		
	}

	public void t1(HttpServletResponse response) throws IOException {
		// 准备内容
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 3000; i++) {
			sb.append("abcd");
		}

		System.out.println("压缩前的数据大小：" + sb.toString().getBytes().length);// 12000kb

		/**
		 * 对网页内容进行gzip格式压缩
		 */
		// 1):创建一个临时的缓存容器
		ByteArrayOutputStream buf = new ByteArrayOutputStream();

		// 2):创建GZIOutputStream
		GZIPOutputStream gzip = new GZIPOutputStream(buf);

		// 3):进行压缩
		gzip.write(sb.toString().getBytes());

		// 4):调用结束方法，把缓存内容刷新
		gzip.finish();

		// 5):得到压缩后的内容
		byte[] result = buf.toByteArray();
		System.out.println("压缩后的数据大小：" + result.toString().getBytes().length);

		// 输出到浏览器
		// response.getWriter().write(sb.toString());
		/**
		 * 注意：现在的内容已经是经过gzip算法压缩，必须要告诉浏览器目前输出的内容是gzip压缩格式内容
		 * 怎么告诉需要发送一个头（http协议那块，响应头）
		 */
		response.setHeader("content-encoding", "gzip");

		response.getOutputStream().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
