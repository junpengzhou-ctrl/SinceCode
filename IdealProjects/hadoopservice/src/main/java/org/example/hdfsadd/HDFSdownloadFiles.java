package org.example.hdfsadd;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSdownloadFiles {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.100:9000"),configuration,"root");
        //文件上传
        fileSystem.copyFromLocalFile(new Path("/input/a.txt"),new Path("/output/b.txt"));
        //文件下载
        fileSystem.copyToLocalFile(false,new Path("/input/a.txt"),new Path("d:/cc"),true);
        fileSystem.delete(new Path("/inut/a.txt"),true);
        fileSystem.rename(new Path("/input/a.txt"),new Path("/input/c.txt"));
        fileSystem.close();
    }
}
