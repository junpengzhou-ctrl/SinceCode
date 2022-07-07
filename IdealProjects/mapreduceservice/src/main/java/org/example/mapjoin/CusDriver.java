package org.example.mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.example.mapbean.CusBean;
import org.example.mapmaper.CusMapper;
import org.example.mapreducer.CusReducer;

import java.io.IOException;

public class CusDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job =Job.getInstance(new Configuration());
        job.setJarByClass(CusDriver.class);

        FileInputFormat.setInputPaths(job,new Path("d:/input/orders.csv"),new Path("d:/input/customers.csv"));
        FileOutputFormat.setOutputPath(job,new Path("d:/csc"));

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(CusBean.class);

        job.setOutputKeyClass(CusBean.class);
        job.setOutputValueClass(NullWritable.class);

        job.setMapperClass(CusMapper.class);
        job.setReducerClass(CusReducer.class);

        job.waitForCompletion(true);
    }

}
