package org.example.mapbean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CusBean implements Writable {

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(customer_id);
        dataOutput.writeUTF(customer_name);
        dataOutput.writeUTF(order_id);
        dataOutput.writeUTF(order_status);
        dataOutput.writeInt(flag);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.customer_id = dataInput.readUTF();
        this.customer_name = dataInput.readUTF();
        this.order_id = dataInput.readUTF();
        this.order_status = dataInput.readUTF();
        this.flag = dataInput.readInt();
    }

    @Override
    public String toString() {
        return order_id+"\t"+customer_name+"\t"+order_status;
    }

    private String customer_id;
    private String customer_name;
    private String order_id;
    private String order_status;
    private int flag;



    public CusBean() {
    }

    public CusBean(String customer_id, String customer_name, String order_id, String order_status, int flag) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.order_id = order_id;
        this.order_status = order_status;
        this.flag = flag;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
