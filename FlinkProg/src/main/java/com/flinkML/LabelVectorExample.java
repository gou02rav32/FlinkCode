package com.flinkML;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.CsvReader;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.api.java.DataSet;
public class LabelVectorExample {
	
	public static void main(String[] args) {
		
	}
	public static void labelVector(String args[])
	{
		String filePath = "";
		final ParameterTool params = ParameterTool.fromArgs(args);
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		CsvReader data = env.readCsvFile(filePath);
		//DataSet<String> survival =
		
	}
}
