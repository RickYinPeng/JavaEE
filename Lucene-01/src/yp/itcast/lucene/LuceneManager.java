package yp.itcast.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.xml.builders.NumericRangeQueryBuilder;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
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
 * ����ά��
 * ���	���ų���
 * ɾ��
 * �޸�
 * ��ѯ	���ų���׼��ѯ
 * @author ����
 *
 */
public class LuceneManager {
	
	//����IndexWriter����
	public IndexWriter getIndexWriter() throws Exception{
		Directory directory = FSDirectory.open(new File("G:/temp2/index"));
		Analyzer analyer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyer);
		
		return new IndexWriter(directory, config);
	}
	
	//ȫ��ɾ��
	@Test
	public void testAllDelete() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		indexWriter.deleteAll();
		indexWriter.close();
	}
	
	//��������ɾ��
	@Test
	public void testDelete() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		Query query = new TermQuery(new Term("fileName", "apache"));
		indexWriter.deleteDocuments(query);
		indexWriter.close();
	}

	//�޸�
	@Test
	public void testUpdate() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		Document doc = new Document();
		doc.add(new TextField("fileN", "�����ļ���", Store.YES));
		doc.add(new TextField("fileC", "�����ļ�����", Store.YES));
		indexWriter.updateDocument(new Term("fileName", "lucene"),doc ,new IKAnalyzer());
	}
	
	//IndexSearcher
	//���ز�ѯ����
	public IndexSearcher getIndexSearcher() throws Exception{
//		��һ��������һ��Directory����Ҳ�����������ŵ�λ�á�
		Directory directory = FSDirectory.open(new File("G:/temp2/index"));
//		�ڶ���������һ��indexReader������Ҫָ��Directory����
		IndexReader indexReader = DirectoryReader.open(directory);
//		������������һ��indexsearcher������Ҫָ��IndexReader����
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		return indexSearcher;
	}
	
	//ִ�в�ѯ�Ľ��
	public void printResult(IndexSearcher indexSearcher,Query query) throws Exception{
		TopDocs topDocs = indexSearcher.search(query, 20);
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
	}
	
	//��ѯ����
	@Test
	public void testAllMatchAllDocsQuery() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		Query query = new MatchAllDocsQuery();
		System.out.println(query);
		printResult(indexSearcher, query);
		
		//�ر���Դ
		indexSearcher.getIndexReader().close();
	}
		
	//������ֵ��Χ��ѯ
	@Test
	public void testNumericRangeQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		//������ѯ
		//������
		//1.����
		//2.��Сֵ
		//3.���ֵ
		//4.�Ƿ������Сֵ
		//5.�Ƿ�������ֵ
		Query query = NumericRangeQuery.newLongRange("fileSize", 30L, 200l, true, true);
		System.out.println(query);
		printResult(indexSearcher, query);
		
		//�ر���Դ
		indexSearcher.getIndexReader().close();
	}
	
	//������ϲ�ѯ����
	@Test
	public void testBooleanQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		
		BooleanQuery booleanQuery = new BooleanQuery();
		
		Query query1 = new TermQuery(new Term("fileName", "apache"));
		Query query2 = new TermQuery(new Term("fileName", "lucene"));
		//	select * from user where id = 1 and name = 'safdsa'
		booleanQuery.add(query1, Occur.MUST);
		booleanQuery.add(query2, Occur.MUST);
		System.out.println(booleanQuery);
		printResult(indexSearcher, booleanQuery);
		//�ر���Դ
		indexSearcher.getIndexReader().close();
	}
	
	//�������͵Ķ����ѯ
	@Test
	public void testQueryParser() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		
		//����1��Ĭ�ϲ�ѯ���� (�������ö��)
		//����2�����õķ�����
		QueryParser queryParser = new QueryParser("fileName",new IKAnalyzer() );
		
		// *:*  �� ��ֵ    
//		Query query = queryParser.parse("*:*");
//		Query query = queryParser.parse("java is apache");
//		Query query = queryParser.parse("fileSize:{30 To 200}");
		Query query = queryParser.parse("+fileName:apache -fileName:lucene");
		
		printResult(indexSearcher, query);
		//�ر���Դ
		indexSearcher.getIndexReader().close();
	}
	
	//���������͵Ķ����ѯ  ���Ĭ�������
	@Test
	public void testMultiFieldQueryParser() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		
		//����1��Ĭ�ϲ�ѯ���� (�������ö��)
		//����2�����õķ�����
		String[] field = {"fileName","fileContent"};
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(field,new IKAnalyzer() );
		Query query = queryParser.parse("apache is lucene");
		
		
		printResult(indexSearcher, query);
		//�ر���Դ
		indexSearcher.getIndexReader().close();
	}
	
}
