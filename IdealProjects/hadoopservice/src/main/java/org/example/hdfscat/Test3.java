package org.example.hdfscat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test3 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://192.168.56.100:9000"),configuration,"root");
        RemoteIterator<LocatedFileStatus> file = fileSystem.listFiles(new Path("/"),true);

        while (file.hasNext()){
            LocatedFileStatus fileStatus = file.next();
            fileStatus.getPermission();
            fileStatus.getGroup();
            fileStatus.getPath().getName();
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation blockLocation:blockLocations){
               String[] hosts =  blockLocation.getHosts();
               for (String s: hosts){
                   System.out.println(s);
               }
            }
        }


    }
}
