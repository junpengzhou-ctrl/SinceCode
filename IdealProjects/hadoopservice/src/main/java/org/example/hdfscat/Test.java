package org.example.hdfscat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.102:9000"),configuration,"hadoop");
        //获得文件详情
        RemoteIterator<LocatedFileStatus> file = fileSystem.listFiles(new Path("/"),true) ;
        while (file.hasNext()){
            LocatedFileStatus fileStatus = file.next();
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getPath().getName());
        //获得块的信息
            BlockLocation[] blockLocations =fileStatus.getBlockLocations();
            for (BlockLocation bl:blockLocations){
                //获得存取的节点
                String []hosts = bl.getHosts();
                for (String host:hosts){
                    System.out.println(host);
                }
            }

        }
    }
}
