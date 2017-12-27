package com.FlinkProg;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch2.ElasticsearchSink;
import org.apache.flink.streaming.connectors.elasticsearch2.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch2.RequestIndexer;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.*;

public class ElasticSearchConnec {
	public static void main(String[] args) {
		elasticSearchCon();
	}
	public static void elasticSearchCon()
	{
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		String filePath = "/home/bizruntime/accounts.json";
		DataStream<String> popularSpots = env.readTextFile(filePath);
		Map<String, String> config = new HashMap<>();
		config.put("bulk.flush.max.actions", "1");   // flush inserts after every event
		config.put("cluster.name", "elasticsearch"); // default cluster name

		List<InetSocketAddress> transports = new ArrayList<>();
		// set default connection details
		try {
			transports.add(new InetSocketAddress(InetAddress.getByName("localhost"), 9300));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		popularSpots.addSink(
		  new ElasticsearchSink<>(config, transports, new ElasticsearchSinkFunction<String>() {
			  public IndexRequest createIndexRequest(String element) {
			        Map<String, String> json = new HashMap<>();
			        json.put("balance", element);         // timestamp
			    
			        return Requests.indexRequest()
			                .index("my-index")
			                .type("my-type")
			                .source(json);
			    }
			@Override
			public void process(String element, RuntimeContext ctx, RequestIndexer indexer) {
				 indexer.add(createIndexRequest(element));
				
			}
		}));
		try {
			env.execute("Viper Flink!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

