package com.wendy.service.impl;

import com.wendy.mapper.OrderMapper;
import com.wendy.pojo.Orders;
import com.wendy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String getGenerateOrderId() {
        return orderMapper.getGenerateOrderId();
    }

    @Override
    public void addNewOrder(Orders orders) {
        orderMapper.addNewOrder(orders);
    }
}
