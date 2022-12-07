package com.itheima.multi.domain;

import java.util.Date;

public class Order {

    private int id;
    private Date ordertime;
    private double total;

    private int uid;

    //当前订单属于哪一个用户
    private User user;

    public Order(int id, Date ordertime, double total, int uid, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.uid = uid;
        this.user = user;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
