package com.fsoft.recomendation.mapreduce.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

import com.fsoft.recomendation.mapreduce.reducer.DistinctValueReducer;
import com.fsoft.recommendation.mapreduce.mapper.DistinctValuesMapper;
import com.fsoft.recommendation.ultils.ConstantValue;


public class DistinctValueDriver extends Configured implements Tool {
	
	private Logger LOG = Logger.getLogger(DistinctValueDriver.class);
	
	public static void main(String[] params) throws Exception {

		int exitCode = ToolRunner.run(new Configuration(), new DistinctValueDriver(), params);
		System.exit(exitCode);
	}

	public int run(String[] arg0) {
		
		String jobName = "Get Distinct Value For MetaData";
		try {
			Configuration conf = getConf();
			Job job = new Job(conf, jobName);
			LOG.info(jobName + " is running");
			
			String input = conf.get(ConstantValue.INPUT) + "/" + conf.get(ConstantValue.BATCH_NUMBER);
			String output = conf.get(ConstantValue.OUTPUT) + "/" + conf.get(ConstantValue.BATCH_NUMBER);
	
			job.setJarByClass(DistinctValueDriver.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			job.setMapperClass(DistinctValuesMapper.class);
			
			job.setReducerClass(DistinctValueReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			FileInputFormat.addInputPath(job, new Path(input));
			FileOutputFormat.setOutputPath(job, new Path(output));
			
			
			boolean result = job.waitForCompletion(true);
			return result ? 0 : 1;
		}
		catch(Exception e) {
			LOG.info("Exception throw while running " + jobName + " Job");
			LOG.info(e.getMessage());
			return 1;
		}
	}

}
