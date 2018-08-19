package yp.itcast.c_decorator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 装饰者模式
 * @author 鹏鹏
 *
 */
public class Demo1 {
	
	/**
	 * 需求：使用BufferedReader读取一个文件内容
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		 oldMethod();
		
		BufferedReader b = new BufferedReader(new FileReader("news.txt"));
		//对BufferedReader进行装饰
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
	 * 改造：在每行名字的前面加上一个序号
	 * 解决方法：希望readLine方法返回给我们的就是一个带序号的内容。对BufferedReader的readLine方法进行增强。
	 * 	使用装饰者模式的开发步骤：
	 * 		概念：装饰者  和  被装饰者（BufferedReader）
	 * 			1）：编写一个BufferedReader装饰者类，继承被装饰者类（不能是final的）；
	 * 			2）：在装饰者类中定义一个成员变量，用于接收被装饰者的对象；
	 * 			3）：在装饰者类的构造方法中传入被装饰者类，使用第二部定义的变量接收被传入的装饰者类；
	 * 			4）：在装饰者类中重写被装饰者类方法，对其方法进行增强。
	 */
	
}

/**
 * 1）：编写一个BufferedReader装饰者类(BufferedReader是非final的)
 */
class MyBufferedReader extends BufferedReader {
	
	/**
	 * 2）：在装饰者类中定义一个成员变量，用于接收被装饰者的对象；
	 * @param in
	 */
	private BufferedReader br;
	
	/**
	 * 3）：在装饰者类的构造方法中传入被装饰者类，使用第二部定义的变量接收被传入的装饰者类；
	 * @param in
	 */
	public MyBufferedReader(Reader in) {
		super(in);
		this.br = (BufferedReader) in;
	}
	
	int count = 1;
	@Override
	public String readLine() throws IOException {
		//得到原来的真实的内容
		String content = br.readLine();
		//加强：加上序号
		if(content!=null){
			content = count+":"+content;
			count++;
		}
		return content;
	}
	
	
	
}

