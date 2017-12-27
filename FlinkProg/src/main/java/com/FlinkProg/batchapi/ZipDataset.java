package com.FlinkProg.batchapi;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.DataSetUtils;
import org.apache.flink.core.fs.FileSystem.WriteMode;

public class ZipDataset {
	public static void main(String[] args) {
		String resultPath = "/home/bizruntime/count/zip.csv";
		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		env.setParallelism(2);
		DataSet<String> in = env.fromElements("A", "B", "C", "D", "E", "F", "G", "H");
		
		DataSet<Tuple2<Long, String>> result = DataSetUtils.zipWithIndex(in);
		
		result.writeAsCsv(resultPath, "\n", ",", WriteMode.OVERWRITE);
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
