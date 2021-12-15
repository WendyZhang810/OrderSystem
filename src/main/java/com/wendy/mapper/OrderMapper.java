package com.wendy.mapper;

import com.wendy.pojo.Orders;

public interface OrderMapper {
    String getGenerateOrderId();

    void addNewOrder(Orders orders);
}
