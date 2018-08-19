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
		//2����ִ��Ŀ�����
		// t1(response);
		// ׼������
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 3000; i++) {
			sb.append("abcd");
		}
		/**
		 * ע�⣺ÿ��д������ҳ���ݶ����Ѿ�����gizpѹ��������
		 */
		response.getWriter().write(sb.toString());
		
	}

	public void t1(HttpServletResponse response) throws IOException {
		// ׼������
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 3000; i++) {
			sb.append("abcd");
		}

		System.out.println("ѹ��ǰ�����ݴ�С��" + sb.toString().getBytes().length);// 12000kb

		/**
		 * ����ҳ���ݽ���gzip��ʽѹ��
		 */
		// 1):����һ����ʱ�Ļ�������
		ByteArrayOutputStream buf = new ByteArrayOutputStream();

		// 2):����GZIOutputStream
		GZIPOutputStream gzip = new GZIPOutputStream(buf);

		// 3):����ѹ��
		gzip.write(sb.toString().getBytes());

		// 4):���ý����������ѻ�������ˢ��
		gzip.finish();

		// 5):�õ�ѹ���������
		byte[] result = buf.toByteArray();
		System.out.println("ѹ��������ݴ�С��" + result.toString().getBytes().length);

		// ����������
		// response.getWriter().write(sb.toString());
		/**
		 * ע�⣺���ڵ������Ѿ��Ǿ���gzip�㷨ѹ��������Ҫ���������Ŀǰ�����������gzipѹ����ʽ����
		 * ��ô������Ҫ����һ��ͷ��httpЭ���ǿ飬��Ӧͷ��
		 */
		response.setHeader("content-encoding", "gzip");

		response.getOutputStream().write(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
