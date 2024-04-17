package com.zxr.cloud.controller;


import com.zxr.cloud.entities.Pay;
import com.zxr.cloud.entities.PayDTO;
import com.zxr.cloud.resp.ResultData;
import com.zxr.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        log.info("*****添加支付流水：" + pay);
        int i = payService.add(pay);

        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        log.info("*****删除支付流水，流水ID为：" + id);
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        log.info("*****修改支付流水：" + payDTO);
        Pay pay = new Pay();

        BeanUtils.copyProperties(payDTO,pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        log.info("*****查询支付流水，流水ID为：" + id);

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/get/all")
    @Operation(summary = "查所有流水",description = "查询全部支付流水方法")
    public ResultData<List<Pay>> getAll(){
        log.info("*****查询全部支付流水");
        List<Pay> list = payService.getAll();
        return ResultData.success(list);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${zxr.info}") String zxrInfo) {
        return "url: " + zxrInfo + "\t" + "port: " + port;
    }

}
