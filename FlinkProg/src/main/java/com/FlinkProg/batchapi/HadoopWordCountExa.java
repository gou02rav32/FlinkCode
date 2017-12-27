package com.FlinkProg.batchapi;

/*import java.io.IOException;

import org.apache.camel.model.language.TokenizerExpression;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.aggregation.Aggregations;
import org.apache.flink.api.java.hadoop.mapreduce.HadoopInputFormat;
import org.apache.flink.api.java.hadoop.mapreduce.HadoopOutputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.hadoopcompatibility.mapred.HadoopMapFunction;
import org.apache.flink.hadoopcompatibility.mapred.HadoopReduceCombineFunction;
import org.apache.flink.util.Collector;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class HadoopWordCountExa {
	public static void main(String[] args) throws Exception{
		ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		// Set up the Hadoop TextInputFormat.
		Job job = Job.getInstance();
		HadoopInputFormat<LongWritable, Text> hadoopIF =
		  new HadoopInputFormat<LongWritable, Text>(
		    new TextInputFormat(), LongWritable.class, Text.class, job
		  );
		TextInputFormat.addInputPath(job, new Path(inputPath));

		// Read data using the Hadoop TextInputFormat.
		DataSet<Tuple2<LongWritable, Text>> text = env.createInput(hadoopIF);

		DataSet<Tuple2<Text, LongWritable>> result = text
		  // use Hadoop Mapper (Tokenizer) as MapFunction
		  .flatMap(new HadoopMapFunction<LongWritable, Text, Text, LongWritable>(
	
		  ))
		  .groupBy(0)
		  // use Hadoop Reducer (Counter) as Reduce- and CombineFunction
		  .reduceGroup(new HadoopReduceCombineFunction<Text, LongWritable, Text, LongWritable>(
		    new Counter(), new Counter()
		  ));

		// Set up the Hadoop TextOutputFormat.
		HadoopOutputFormat<Text, IntWritable> hadoopOF =
		  new HadoopOutputFormat<Text, IntWritable>(
		    new TextOutputFormat<Text, IntWritable>(), job
		  );
		hadoopOF.getConfiguration().set("mapreduce.output.textoutputformat.separator", " ");
		TextOutputFormat.setOutputPath(job, new Path(outputPath));

		// Emit data using the Hadoop TextOutputFormat.
		result.output(hadoopOF);

		// Execute Program
		env.execute("Hadoop WordCount");
	}
}
}
*/