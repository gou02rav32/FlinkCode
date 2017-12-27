package com.flinkTable;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.StreamTableEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.BatchTableEnvironment;

public class TableExplainingMode {
	public static void main(String[] args) {
		explainTable();
	}
	public static void explainTable()
	{
			StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
			StreamTableEnvironment tEnv = TableEnvironment.getTableEnvironment(env);
			
			DataStream<Tuple2<Integer, String>> stream1 = env.fromElements(new Tuple2<>(1, "hello"));
			DataStream<Tuple2<Integer, String>> stream2 = env.fromElements(new Tuple2<>(1, "hello"));
	}
}
