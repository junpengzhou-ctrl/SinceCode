package org.example.hdfsIO;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UpfiletoHdfs {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem =FileSystem.get(new URI("hdfs://192.168.56.102:9000"),configuration,"root");
        //获取输入流
       FileInputStream fis = new FileInputStream(new File("e:/input/a.txt"));
       //获取输出流
        FSDataOutputStream fos = fileSystem.create(new Path("/cc.txt"));

        IOUtils.copyBytes(fis,fos,configuration);
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
        fileSystem.close();
    }
}
