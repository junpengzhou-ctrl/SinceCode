package services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 字符串分割分组
 */
public class MyGroupMap {

    public Map<String,Integer>myCount() {
        //获取字符串
        StringBuffer sb = new ReadFileInfo().getContext();
        //根据正则进行字符串分割
        String[] words = sb.toString().split("[\\s|\\,|\\,|!|?]");
        Map<String,Integer> map = new HashMap<String, Integer>();
        //开启线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < words.length; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!words[i].trim().equals("")) {
//                System.out.println(i + ":" + words[i]);
                pool.execute(new MyThread(words[i].trim(),map));
            }
        }
        pool.shutdown();
        while (pool.isTerminated()){
            System.out.println(map);
        }
        return  map;
    }

}
