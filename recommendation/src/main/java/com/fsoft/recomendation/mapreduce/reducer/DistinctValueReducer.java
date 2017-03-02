package com.fsoft.recomendation.mapreduce.reducer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DistinctValueReducer extends Reducer<Text, Text, Text, Text> {

}
