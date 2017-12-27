package com.TableAPIEx;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.core.fs.FileSystem.WriteMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;

//import twitter4j.Twitter;

import org.apache.flink.table.sources.DefinedProctimeAttribute;
import org.apache.flink.table.sources.StreamTableSource;
import org.apache.flink.types.Row;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Properties;
import java.util.StringTokenizer;

public class StreamingTable {
	public static void main(String[] args) {
		streamTable();
	}
	public static void streamTable()
	{
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		StreamTableEnvironment tableEnv = TableEnvironment.getTableEnvironment(env);
		DataStream<String> tableStream = twitterStream(env);//env.fromElements("A", "B", "C", "D", "E");
		/*System.out.println(tableStream.toString());
		Table table = tableEnv.fromDataStream(tableStream); //"Name, GeoLocation, CreatedAt, Location, Language");
		tableEnv.registerTable("TwitterTable", table);
		System.out.println(table.toString());
		Table sqlResult  = tableEnv.sql("SELECT * from TwitterTable");
		System.out.println(sqlResult.toString());*/
		
		//DataStream<Row> dsRow = tableEnv.toAppendStream(table, Row.class);
		try {
			env.execute("Table Api");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//public static void twitterStream() 
	public static DataStream<String> twitterStream(StreamExecutionEnvironment env)
	{
		Properties props = new Properties();
		props.setProperty(TwitterSource.CONSUMER_KEY, "JSsHTgx0wLplIVv0aB5WDSv1r");
		props.setProperty(TwitterSource.CONSUMER_SECRET, "FghrKOEg5LjWAfuXpCmKy1Rmvi3PbbWborSxJnwGfKJr29KPph");
		props.setProperty(TwitterSource.TOKEN, "762358962301775873-d8VdlMKTXLdqbynyy9luGADT1RHzR1v");
		props.setProperty(TwitterSource.TOKEN_SECRET, "YbCXayhhiyoe4eLBKR8gx8jbDWavDGSrnTtfod61N66WV");
		// set up the execution environment
		env = StreamExecutionEnvironment.getExecutionEnvironment();
		DataStream<String> streamSource = env.addSource(new TwitterSource(props)); 
		//Twitter status = (Twitter) streamSource;
		//streamSource.iterate(100000);
		//DataStream<String> tweets = streamSource.flatMap(new SelectEnglishAndTokenizeFlatMap()).keyBy(0).sum(1);
		
		System.out.println("Printing result to stdout. Use --output to specify output path.");
		
		
		//streamSource.print();
		
		streamSource.writeAsText("/home/bizruntime/twitterData", WriteMode.OVERWRITE);
		//return tweets;
		return streamSource;
	/*	try {
			env.execute("Twitter Streaming Example");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	/*public static class UserActionSource implements StreamTableSource<Row>, DefinedProctimeAttribute {
		@Override
		public DataStream<Row> getDataStream(StreamExecutionEnvironment execEnv) {
			// create stream 
			DataStream<Row> stream = ...;
			return stream;
		}

		@Override
		public String getProctimeAttribute() {
			// field with this name will be appended as a third field 
			return "UserActionTime";
		}

		@Override
		public String explainSource() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TypeInformation<Row> getReturnType() {
			/String[] names = new String[] {"Username" , "Data"};
			TypeInformation[] types = new TypeInformation[] {Types.STRING(), Types.STRING()};
			return Types.ROW(types);
		}
	}*/

	// *************************************************************************

	// USER FUNCTIONS

	// *************************************************************************
	public static class SelectEnglishAndTokenizeFlatMap implements FlatMapFunction<String, Tuple2<String, Integer>> {

		private static final long serialVersionUID = 1L;
		private transient ObjectMapper jsonParser;
		@Override
		public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
			if (jsonParser == null) {
				jsonParser = new ObjectMapper();
			}
			JsonNode jsonNode = jsonParser.readValue(value, JsonNode.class);
			boolean isEnglish = jsonNode.has("user") && jsonNode.get("user").has("lang") && jsonNode.get("user").get("lang").asText().equals("en");
			boolean hasText = jsonNode.has("text");
			if (isEnglish && hasText) {
				StringTokenizer tokenizer = new StringTokenizer(jsonNode.get("text").asText());
				while (tokenizer.hasMoreTokens()) {

					String result = tokenizer.nextToken().replaceAll("\\s*", "").toLowerCase();
					if (!result.equals("")) {

						out.collect(new Tuple2<>(result, 1));

					}

				}

			}

		}

	}
}
