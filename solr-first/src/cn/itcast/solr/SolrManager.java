package cn.itcast.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrManager {
	
	
	
	
	//添加索引
	@Test
	public void addIndex() throws SolrServerException, IOException{
		//1.获取solr服务器
		SolrServer  solrServer = new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//执行solrServer的添加方法
		SolrInputDocument doc = new  SolrInputDocument();
		doc.addField("name", "solr添加的name");
		doc.addField("content", "solr添加的content");
		doc.addField("id", "2");
		solrServer.add(doc);
		solrServer.commit();
	}
	
	//修改索引
	@Test
	public void updateIndex() throws SolrServerException, IOException{
		//1.获取solr服务器
		SolrServer  solrServer = new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//执行solrServer的添加方法
		SolrInputDocument doc = new  SolrInputDocument();
		doc.addField("name", "solr添加后修改的name");
		doc.addField("content", "solr添加后修改的content");
		doc.addField("id", "2");
		solrServer.add(doc);
		solrServer.commit();
	}
	
	
	//删除索引
	@Test
	public void deleteIndex() throws SolrServerException, IOException{
		//1.获取solr服务器
		SolrServer  solrServer = new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//执行solrServer的添加方法
		
		solrServer.deleteById("2");
		solrServer.commit();
	}

	
	
	//查询索引
	@Test
	public void selectIndex() throws SolrServerException, IOException{
		//1.获取solr服务器
		SolrServer  solrServer = new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//执行solrServer的添加方法
		SolrQuery  solrQuery = new  SolrQuery();
		solrQuery.set("id:3");
		QueryResponse query = solrServer.query(solrQuery);
		System.out.println(query);

张三改了代码
主人也改了代码
	}

}
