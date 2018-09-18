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
 * 索引维护
 * 添加	入门程序
 * 删除
 * 修改
 * 查询	入门程序精准查询
 * @author 鹏鹏
 *
 */
public class LuceneManager {
	
	//返回IndexWriter对象
	public IndexWriter getIndexWriter() throws Exception{
		Directory directory = FSDirectory.open(new File("G:/temp2/index"));
		Analyzer analyer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyer);
		
		return new IndexWriter(directory, config);
	}
	
	//全部删除
	@Test
	public void testAllDelete() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		indexWriter.deleteAll();
		indexWriter.close();
	}
	
	//根据条件删除
	@Test
	public void testDelete() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		Query query = new TermQuery(new Term("fileName", "apache"));
		indexWriter.deleteDocuments(query);
		indexWriter.close();
	}

	//修改
	@Test
	public void testUpdate() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
		Document doc = new Document();
		doc.add(new TextField("fileN", "测试文件名", Store.YES));
		doc.add(new TextField("fileC", "测试文件内容", Store.YES));
		indexWriter.updateDocument(new Term("fileName", "lucene"),doc ,new IKAnalyzer());
	}
	
	//IndexSearcher
	//返回查询对象
	public IndexSearcher getIndexSearcher() throws Exception{
//		第一步：创建一个Directory对象，也就是索引库存放的位置。
		Directory directory = FSDirectory.open(new File("G:/temp2/index"));
//		第二步：创建一个indexReader对象，需要指定Directory对象。
		IndexReader indexReader = DirectoryReader.open(directory);
//		第三步：创建一个indexsearcher对象，需要指定IndexReader对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		return indexSearcher;
	}
	
	//执行查询的结果
	public void printResult(IndexSearcher indexSearcher,Query query) throws Exception{
		TopDocs topDocs = indexSearcher.search(query, 20);
//		第六步：返回查询结果。遍历查询结果并输出。
		ScoreDoc[] docs = topDocs.scoreDocs;//拿到的是文档的ID
		for (ScoreDoc scoreDoc : docs) {
			int doc = scoreDoc.doc; //文档的ID
			Document document = indexSearcher.doc(doc);
			//文件名字
			String fileName = document.get("fileName");
			System.out.println(fileName);
			//文件内容
			String fileContent = document.get("fileContent");
//			System.out.println(fileContent);
			//文件大小
			String fileSize = document.get("fileSize");
			System.out.println(fileSize);
			//文件路径
			String filePath = document.get("filePath");
			System.out.println(filePath);
			System.out.println("-------********************--------");
		}
	}
	
	//查询所有
	@Test
	public void testAllMatchAllDocsQuery() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		Query query = new MatchAllDocsQuery();
		System.out.println(query);
		printResult(indexSearcher, query);
		
		//关闭资源
		indexSearcher.getIndexReader().close();
	}
		
	//根据数值范围查询
	@Test
	public void testNumericRangeQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		//创建查询
		//参数：
		//1.域名
		//2.最小值
		//3.最大值
		//4.是否包含最小值
		//5.是否包含最大值
		Query query = NumericRangeQuery.newLongRange("fileSize", 30L, 200l, true, true);
		System.out.println(query);
		printResult(indexSearcher, query);
		
		//关闭资源
		indexSearcher.getIndexReader().close();
	}
	
	//可以组合查询条件
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
		//关闭资源
		indexSearcher.getIndexReader().close();
	}
	
	//条件解释的对象查询
	@Test
	public void testQueryParser() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		
		//参数1：默认查询的域 (可以设置多个)
		//参数2：采用的分析器
		QueryParser queryParser = new QueryParser("fileName",new IKAnalyzer() );
		
		// *:*  域 ：值    
//		Query query = queryParser.parse("*:*");
//		Query query = queryParser.parse("java is apache");
//		Query query = queryParser.parse("fileSize:{30 To 200}");
		Query query = queryParser.parse("+fileName:apache -fileName:lucene");
		
		printResult(indexSearcher, query);
		//关闭资源
		indexSearcher.getIndexReader().close();
	}
	
	//多条件解释的对象查询  多个默认域对象
	@Test
	public void testMultiFieldQueryParser() throws Exception{
		IndexSearcher indexSearcher = getIndexSearcher();
		
		//参数1：默认查询的域 (可以设置多个)
		//参数2：采用的分析器
		String[] field = {"fileName","fileContent"};
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(field,new IKAnalyzer() );
		Query query = queryParser.parse("apache is lucene");
		
		
		printResult(indexSearcher, query);
		//关闭资源
		indexSearcher.getIndexReader().close();
	}
	
}
