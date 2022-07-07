package services;

import java.util.HashMap;
import java.util.Map;

public class MyThread extends Thread {
    /**
     * 存放分组结果的集合
     */
    public  Map<String,Integer> map ;

   String word;

    public MyThread(String word,Map mp) {
        this.word = word;
        this.map =mp;
    }

    @Override
    public void run() {
        countWord();


    }

    public   void  countWord(){
        //锁上map 集合 确保操作map的线程只有1个

        synchronized (map){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (map.containsKey(word)){
                //已有
                //获取对应的值
                int num = map.get(word);
                map.put(word,num+1);
            }else {
                //没有找到
                map.put(word,1);
            }


        }

    }
}
