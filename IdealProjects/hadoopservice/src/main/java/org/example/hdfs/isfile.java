package org.example.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class isfile {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fs= FileSystem.get(new URI("hdfs://192.168.56.100"),configuration,"root");
        //判断是文件还是文件夹
        FileStatus[] file= fs.listStatus(new Path("/"));
        for(FileStatus fsss:file){
            if (fsss.isFile()){
                System.out.println("f:"+fsss.getPath().getName());
            }else {
                System.out.println("d:"+fsss.getPath().getName());
            }
        }
        fs.close();
    }
}
