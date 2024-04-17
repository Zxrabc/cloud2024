package com.zxr.cloud.controller;


import com.zxr.cloud.entities.PayDTO;
import com.zxr.cloud.resp.ResultData;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.Resource;
import org.aopalliance.intercept.Interceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id")Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/del/" + id,ResultData.class);
    }

    @PostMapping(value = "/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update",payDTO,ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
