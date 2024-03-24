package com.beidao.cloud.controller;

import com.beidao.cloud.entities.PayDTO;
import com.beidao.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    // 删除+修改操作作为家庭作业
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

   /* @GetMapping("/consumer/pay/del")
    public ResponseEntity<ResultData> deletePayInfo(PayDTO payDTO) {
        ResponseEntity<ResultData> response = restTemplate.exchange(PaymentSrv_URL + "/pay/del/",
                HttpMethod.DELETE, new HttpEntity<>(payDTO), ResultData.class);
        return response;
    }*/


}
