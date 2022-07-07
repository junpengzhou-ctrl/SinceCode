package org.example.hdfsadd;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFsAddfile {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration cs = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.56.100:9000"),cs,"root");
        //上传文件
        fs.copyFromLocalFile(new Path("/input/aa.txt"),new Path("/output/aa.txt"));
        //下载文件
        fs.copyToLocalFile(false,new Path("/input/a.txt"),new Path("e:/a.txt"),true);
        fs.close();
    }
}
