package com.itheima.multi.mapper;

import com.itheima.multi.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findAll();

    int save(Order order);
}
