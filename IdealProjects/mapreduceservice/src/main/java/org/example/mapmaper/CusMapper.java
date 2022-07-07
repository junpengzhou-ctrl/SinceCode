package org.example.mapmaper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.example.mapbean.CusBean;

import java.io.IOException;

public class CusMapper<CusBean> extends Mapper<LongWritable, Text,Text, CusBean> {
    //CusBean cb = new CusBean();
    org.example.mapbean.CusBean  cb = new org.example.mapbean.CusBean();
    String name;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        //根据分片来获取名字
        FileSplit FS = (FileSplit) context.getInputSplit();
        name = FS.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String [] split = value.toString().split(",");
        if (name.startsWith("orders")){
            cb.setCustomer_id(split[2]);
            cb.setCustomer_name("");
            cb.setOrder_id(split[0]);
            cb.setOrder_status(split[3]);
            cb.setFlag(1);
        }else {
            cb.setCustomer_id(split[0]);
            cb.setCustomer_name(split[1]);
            cb.setOrder_id("");
            cb.setOrder_status("");
            cb.setFlag(0);
        }
        context.write(new Text(cb.getCustomer_id()),(CusBean)cb);
    }
}
