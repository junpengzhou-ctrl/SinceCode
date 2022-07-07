package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;

public class HbaseService {
    public static Connection getConnection() throws IOException {
        //配置端口和zookeeper的主机名字都是默认的所以可以不用设置。
        Configuration configuration = HBaseConfiguration.create();

        Connection connection = ConnectionFactory.createConnection(configuration);
        return connection;
    }

    //表结构的操作增删改查 调admin 表数据的增删改查 调 table

    public static void main(String[] args) throws IOException {
        //创建表
        createTable();

        //向表中插入数据
        insertTable();

        //查询表中对应的数据
        searchTable();

        //查询所有
        searchAll();

    }

    private static void searchAll() throws IOException {

        //FILTER =>(=,'substring:c')
        Table emps = getConnection().getTable(TableName.valueOf("emps"));
        Scan scan = new Scan();
        FilterList filterList = new FilterList();
        ValueFilter valueFilter = new ValueFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator("c"));
        filterList.addFilter(valueFilter);
        scan.setFilter(filterList);
        //相当于select * from userinfo
        ResultScanner scanner = emps.getScanner(new Scan()); //拿出结果集
        Iterator<Result> rs = scanner.iterator();
        while (rs.hasNext()){
            Result row = rs.next();
            System.out.println(row.getValue("base".getBytes(),"name".getBytes()));
           // row.getValue("base".getBytes(),"age".getBytes());
        }
    }

    private static void searchTable() throws IOException {
         //get 'emps','001','base:name'
        Table emps = getConnection().getTable(TableName.valueOf("emps"));
        Get get = new Get("001".getBytes());
        Result result = emps.get(get);
        String str = Bytes.toString(result.getValue("base".getBytes(),"name".getBytes()));
        System.out.println(str);
    }

    private static void insertTable() throws IOException {
        //put 'emps','001','base:name','value'
        Table emps = getConnection().getTable(TableName.valueOf("emps"));
        Put put = new Put("001".getBytes());
        put.addColumn("base".getBytes(),"name".getBytes(),"mm".getBytes());
        emps.put(put);
    }

    private static void createTable() throws IOException {
        Admin admin = getConnection().getAdmin();
        //create 'emps','base'
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf("emps")); //表名
        HColumnDescriptor base = new HColumnDescriptor("base");  //列族
        table.addFamily(base);
        admin.createTable(table);
    }
}
