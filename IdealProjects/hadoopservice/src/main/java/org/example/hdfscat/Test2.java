package org.example.hdfscat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test2 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //获取文件系统
        Configuration configuration =new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.102:9000"),configuration,"root");
        //获取文件详情
        RemoteIterator<LocatedFileStatus> file= fileSystem.listFiles(new Path("/"),true);
        while(file.hasNext()){
            LocatedFileStatus fileStatus = file.next();
            fileStatus.getGroup();
            fileStatus.getPermission();
            //...
            //获得存储块大小
            BlockLocation [] blockLocations=fileStatus.getBlockLocations();
            for (BlockLocation bl: blockLocations){
                //获得主机节点
               String host[] =  bl.getHosts();
               for (String s:host){
                   System.out.println(s);
               }
            }

        }
    }
}
