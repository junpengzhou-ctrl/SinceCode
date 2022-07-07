package org.example.hdfsIO;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class DownfromHdfs {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.102:9000"),configuration,"root");
        //获取输入流
        FSDataInputStream fsd = fileSystem.open(new Path("/input/a.txt"));
        //获取输出流
        FileOutputStream fid = new FileOutputStream(new File("e:/a.txt"));
        //流的拷贝
        byte [] bytes = new byte[1024];
        for (int i = 0; i < 1024*128 ; i++) {
            fid.close();
            fsd.close();
        }
        IOUtils.closeStream(fid);
        IOUtils.closeStream(fsd);

    }
}
