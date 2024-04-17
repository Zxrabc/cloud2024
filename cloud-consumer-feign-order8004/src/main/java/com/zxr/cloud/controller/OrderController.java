package com.zxr.cloud.controller;


import com.zxr.cloud.apis.PayFeignApi;
import com.zxr.cloud.entities.PayDTO;
import com.zxr.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    
    @Resource
    private PayFeignApi payFeignApi;


    @PostMapping(value = "/feign/pay/add")
    public ResultData add(@RequestBody PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return payFeignApi.getPayInfo(id);
    }

    @GetMapping(value = "/feign/pay/mylb")
    public String mylb(){
        return payFeignApi.mylb();
    }

}
