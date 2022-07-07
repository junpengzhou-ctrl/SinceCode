package org.example.hdfscat;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 查看文件内容
 */

public class HdfsCatfile {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.103:9000"),configuration,"root");
        //获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"),true);
        while(listFiles.hasNext()){
            LocatedFileStatus fs = listFiles.next();
            System.out.println(fs.getPath());
            //获得文件的名称
            System.out.println(fs.getPath().getName());
            //获得大小
            System.out.println(fs.getLen());
            //文件权限
            System.out.println(fs.getPermission());
            //组
            System.out.println(fs.getGroup());


            //获得存储块的信息
            BlockLocation[] blockLocations =fs.getBlockLocations();
            for (BlockLocation bf: blockLocations){
                //获取块存储的主机节点
                String [] hosts = bf.getHosts();
                for (String host:hosts){
                    System.out.println(host);
                }
            }

        }


    }

}
