package com.fsoft.recommendation.mapreduce.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DistinctValuesMapper extends Mapper<LongWritable, Text, Text, Text> {
	
}
