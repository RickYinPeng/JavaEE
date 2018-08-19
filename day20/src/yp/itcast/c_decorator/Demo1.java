package yp.itcast.c_decorator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * װ����ģʽ
 * @author ����
 *
 */
public class Demo1 {
	
	/**
	 * ����ʹ��BufferedReader��ȡһ���ļ�����
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		 oldMethod();
		
		BufferedReader b = new BufferedReader(new FileReader("news.txt"));
		//��BufferedReader����װ��
		BufferedReader br = new MyBufferedReader(b);
		 String str = null;
		 while((str=br.readLine())!=null){
			 System.out.println(str);
		 }
	}

	public static void oldMethod() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("news.txt"));
		 String str = null;
		 while((str=br.readLine())!=null){
			 System.out.println(str);
		 }
	}
	
	/**
	 * ���죺��ÿ�����ֵ�ǰ�����һ�����
	 * ���������ϣ��readLine�������ظ����ǵľ���һ������ŵ����ݡ���BufferedReader��readLine����������ǿ��
	 * 	ʹ��װ����ģʽ�Ŀ������裺
	 * 		���װ����  ��  ��װ���ߣ�BufferedReader��
	 * 			1������дһ��BufferedReaderװ�����࣬�̳б�װ�����ࣨ������final�ģ���
	 * 			2������װ�������ж���һ����Ա���������ڽ��ձ�װ���ߵĶ���
	 * 			3������װ������Ĺ��췽���д��뱻װ�����࣬ʹ�õڶ�������ı������ձ������װ�����ࣻ
	 * 			4������װ����������д��װ�����෽�������䷽��������ǿ��
	 */
	
}

/**
 * 1������дһ��BufferedReaderװ������(BufferedReader�Ƿ�final��)
 */
class MyBufferedReader extends BufferedReader {
	
	/**
	 * 2������װ�������ж���һ����Ա���������ڽ��ձ�װ���ߵĶ���
	 * @param in
	 */
	private BufferedReader br;
	
	/**
	 * 3������װ������Ĺ��췽���д��뱻װ�����࣬ʹ�õڶ�������ı������ձ������װ�����ࣻ
	 * @param in
	 */
	public MyBufferedReader(Reader in) {
		super(in);
		this.br = (BufferedReader) in;
	}
	
	int count = 1;
	@Override
	public String readLine() throws IOException {
		//�õ�ԭ������ʵ������
		String content = br.readLine();
		//��ǿ���������
		if(content!=null){
			content = count+":"+content;
			count++;
		}
		return content;
	}
	
	
	
}

