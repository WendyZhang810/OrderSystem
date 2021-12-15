package com.wendy.service;

import com.wendy.pojo.Orders;

public interface OrderService {
    String getGenerateOrderId();

    void addNewOrder(Orders orders);
}
