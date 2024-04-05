package com.beidao.cloud.apis;


import com.beidao.cloud.entities.PayDTO;
import com.beidao.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    //新增一条支付相关流水记录
    @PostMapping(value = "/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    //按照主键记录查询支付流水信息
    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/get/info")
    public String mylb(); //openfeign也支持负载均衡

}
