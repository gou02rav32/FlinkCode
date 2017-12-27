package com.FlinkProg;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.connectors.elasticsearch2.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch5.ElasticsearchSink;

public class ElasticSearchConnect {
	public static void main(String[] args) {
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		stream.print();
		writeToElastic();
		// execute program
		env.execute("Viper Flink!");
	}
	public static void writeToElastic() {
		Map<String, String> config = new HashMap<>();
		// This instructs the sink to emit after every element, otherwise they would be buffered
		config.put("bulk.flush.max.actions", "1");
		config.put("cluster.name", "es_keira");
		try {
		// Add elasticsearch hosts on startup
		List<InetSocketAddress> transports = new ArrayList<>();
		transports.add(new InetSocketAddress("127.0.0.1", 9300)); // port is 9300 not 9200 for ES TransportClient
		ElasticsearchSinkFunction<String> indexLog = new ElasticsearchSinkFunction<String>() {
		public IndexRequest createIndexRequest(String element) {
		String[] logContent = element.trim().split("\t");
		Map<String, String> esJson = new HashMap<>();
		esJson.put("IP", logContent[0]);
		esJson.put("info", logContent[1]);
		return Requests
		.indexRequest()
		.index("viper-test")
		.type("viper-log")
		.source(esJson);
		}
		@Override
		public void process(String element, RuntimeContext ctx, RequestIndexer indexer) {
		indexer.add(createIndexRequest(element));
		}
		};
		ElasticsearchSink esSink = new ElasticsearchSink(config, transports, indexLog);
		input.addSink(esSink);
		} catch (Exception e) {
		System.out.println(e);
		}
		}
		}
}
