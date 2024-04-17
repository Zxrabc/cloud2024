package com.zxr.cloud.service;

import com.zxr.cloud.entities.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
