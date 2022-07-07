package org.example.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class isfileTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.102:9000"),configuration,"root");
        FileStatus[] file = fileSystem.listStatus(new Path("/"));

        for (FileStatus fs: file){
//            if (fs.isFile()){
//                System.out.println("f:"+fs.getPath().getName());
//            }else {
//                System.out.println("d:"+fs.getPath().getName());
//            }
            if (fs.isDirectory()&&fs.getPath().getName().equals("aaaa")){
                fileSystem.delete( fs.getPath(),true);
            }
        }
        fileSystem.close();
    }
}
