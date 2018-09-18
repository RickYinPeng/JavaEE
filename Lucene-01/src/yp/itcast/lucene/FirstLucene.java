package yp.itcast.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * Lucene	����
 * ��������
 * ��ѯ����
 * @author ����
 *
 */
public class FirstLucene {
	
	//��������
	@Test
	public void testIndex() throws IOException{
//		��һ��������һ��java���̣�������jar����
//		�ڶ���������һ��indexwriter����
		//		1��ָ��������Ĵ��λ��Directory����
			Directory directory = FSDirectory.open(new File("G:/temp2/index"));
		//		2��ָ��һ�������������ĵ����ݽ��з�����
//			Analyzer analyer = new StandardAnalyzer();//�ٷ��Ƽ�����׼��������
			Analyzer analyer = new IKAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyer);
		
		IndexWriter indexWriter = new IndexWriter(directory, config);


//		������������field���󣬽�field��ӵ�document�����С�
		File f = new File("G:/temp2/searchsource");
		File[] files = f.listFiles();
		for (File file : files) {
//			�ڶ���������document����
			Document document = new Document();//ע�⣺����ע��һ��Ҫ��apache.lucene�µ�
		
		//����field����	
			//�ļ�����
			String file_name = file.getName();
			Field fileNameField = new TextField("fileName", file_name, Store.YES);
			//�ļ���С
			long file_size = FileUtils.sizeOf(file);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			//�ļ�·��
			String file_path = file.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			//�ļ�����
			String file_content = FileUtils.readFileToString(file);
			Field fileContentField = new TextField("fileContent", file_content, Store.YES);
		//��field��ӵ�document������
			document.add(fileNameField);
			document.add(fileSizeField);
			document.add(filePathField);
			document.add(fileContentField);
//		���Ĳ���ʹ��indexwriter����document����д�������⣬�˹��̽�����������������������document����д�������⡣
			indexWriter.addDocument(document);
		}
		
//		���岽���ر�IndexWriter����
		indexWriter.close();
	}
	
	//��������
	@Test
	public void testSearch() throws Exception{
//		��һ��������һ��Directory����Ҳ�����������ŵ�λ�á�
		Directory directory = FSDirectory.open(new File("G:/temp2/index"));
//		�ڶ���������һ��indexReader������Ҫָ��Directory����
		IndexReader indexReader = DirectoryReader.open(directory);
//		������������һ��indexsearcher������Ҫָ��IndexReader����
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
//		���Ĳ�������һ��TermQuery����ָ����ѯ����Ͳ�ѯ�Ĺؼ��ʡ�
		Query query = new TermQuery(new Term("fileName", "lucene"));
//		���岽��ִ�в�ѯ��
		TopDocs topDocs = indexSearcher.search(query, 2);
//		�����������ز�ѯ�����������ѯ����������
		ScoreDoc[] docs = topDocs.scoreDocs;//�õ������ĵ���ID
		for (ScoreDoc scoreDoc : docs) {
			int doc = scoreDoc.doc; //�ĵ���ID
			Document document = indexSearcher.doc(doc);
			//�ļ�����
			String fileName = document.get("fileName");
			System.out.println(fileName);
			//�ļ�����
			String fileContent = document.get("fileContent");
//			System.out.println(fileContent);
			//�ļ���С
			String fileSize = document.get("fileSize");
			System.out.println(fileSize);
			//�ļ�·��
			String filePath = document.get("filePath");
			System.out.println(filePath);
			System.out.println("-------********************--------");
		}
//		���߲����ر�IndexReader����
		indexReader.close();
	}
	
	
	//�鿴��׼�������ķִ�Ч��
		@Test
		public void testTokenStream() throws Exception {
			//����һ����׼����������
//			Analyzer analyzer = new StandardAnalyzer();
			
//			Analyzer analyzer = new CJKAnalyzer();
			
//			Analyzer analyzer = new SmartChineseAnalyzer();
			
			Analyzer analyzer = new IKAnalyzer();
			//���tokenStream����
			//��һ����������������������һ��
			//�ڶ���������Ҫ�������ı�����
//			TokenStream tokenStream = analyzer.tokenStream("test", "The Spring Framework provides a comprehensive programming and configuration model.");
			TokenStream tokenStream = analyzer.tokenStream("test", "�߸�˧�����ö�ά��ṹ���߼����ʵ�ֵ�����");
			//���һ�����ã����Ի��ÿ���ؼ���
			CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
			//���һ��ƫ���������ã���¼�˹ؼ��ʵĿ�ʼλ���Լ�����λ��
			OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
			//��ָ��������б��ͷ��
			tokenStream.reset();
			//�����ؼ����б�ͨ��incrementToken�����ж��б��Ƿ����
			while(tokenStream.incrementToken()) {
				//�ؼ��ʵ���ʼλ��
				System.out.println("start->" + offsetAttribute.startOffset());
				//ȡ�ؼ���
				System.out.println(charTermAttribute);
				//����λ��
				System.out.println("end->" + offsetAttribute.endOffset());
			}
			tokenStream.close();
		}
		
		
}
