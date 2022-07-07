package org.example.mapreducer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.example.mapbean.CusBean;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CusReducer extends Reducer<Text, CusBean,CusBean, NullWritable> {
    CusBean cb = new CusBean();
    @Override
    protected void reduce(Text key, Iterable<CusBean> values, Context context) throws IOException, InterruptedException {
        //准备用于存放所有订单的集合
        ArrayList<CusBean> orderbean = new ArrayList<>();

        for (CusBean cc : values){
            try {
                if (1==cc.getFlag()){
                    CusBean sm =new CusBean();
                    BeanUtils.copyProperties(sm,cc);
                    orderbean.add(sm);
                }else {
                    BeanUtils.copyProperties(cb,cc);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (CusBean bean : orderbean){
            bean.setCustomer_name(cb.getCustomer_name());
            context.write(bean,NullWritable.get());
        }
    }
}
