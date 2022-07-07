package org.example.hdfsIO;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class downfiletoHdfs {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem =FileSystem.get(new URI("hdfs://192.168.56.100"),configuration,"root");
        //获得输入流
        FSDataInputStream fis = fileSystem.open(new Path("/input/a.txt"));
        //获取输出流
        FileOutputStream fos = new FileOutputStream(new File("d:/input/ccc.txt"));

//        IOUtils.copyBytes(fis,fos,configuration);
        byte [] buf = new byte[1024];
        for (int i = 0; i < 1024 *128; i++) {
            fis.read(buf);
            fos.write(buf);
        }
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fileSystem.close();
    }
}
