package com.zxr.cloud.controller;


import com.zxr.cloud.entities.Order;
import com.zxr.cloud.resp.ResultData;
import com.zxr.cloud.service.OrderService;
import com.zxr.cloud.service.impl.OrderServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /*
      创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order){
        orderService.create(order);
        return ResultData.success(order);

    }
}
