package com.mozhoudonglu;

import java.io.*;

public class ReadAndWrite {
    /*
    读取一个文件放入另一个文件
     */
    public static void main(String[] args) {
        File nowfile = new File("D:\\谷歌浏览器\\中国大陆安装方法.txt");
        File desfile = new File("D:\\谷歌浏览器\\中国大陆安装方法_copy.txt");
       // copyFile(nowfile,desfile);

        copyFile2(nowfile,desfile);
    }



    public static void copyFile(File nowfile,File desfile){
        //创建输入输出字符流   读入 写出
        if (!desfile.isFile()){
            try {
                desfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nowfile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desfile));   //是否追加

            String s1 = null;
            while ((s1=bufferedReader.readLine())!=null){
                bufferedWriter.write(s1+"\n");
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /*
    字节流输入输出
     */
    public static void copyFile2(File nowfile,File desfile){
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(nowfile));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(desfile,true));
            byte [] bytes = new byte[50];
            int read = 0;
            while((read = inputStream.read(bytes))!= -1){
                outputStream.write(bytes);
            }

            outputStream.close();
            inputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
