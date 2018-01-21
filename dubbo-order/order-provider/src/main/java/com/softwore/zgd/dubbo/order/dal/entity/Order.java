package com.softwore.zgd.dubbo.order.dal.entity;

import java.util.Date;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public class Order {
    private int id;
    private int status;
    private double price;
    private Date order_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }
}
