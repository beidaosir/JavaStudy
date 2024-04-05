package com.beidao.cloud.controller;


import com.beidao.cloud.apis.PayFeignApi;
import com.beidao.cloud.entities.PayDTO;
import com.beidao.cloud.resp.ResultData;
import feign.Feign;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController
{
    @Resource
    private PayFeignApi payFeignApi;


    @PostMapping(value = "/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){

        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;

    }

   /* Feign 客户端在内部构建了请求的详细信息，并将接口方法调用转换为 HTTP 调用。
    当应用启动时，Feign 使用 Java 的动态代理机制生成接口的实现。这个过程由 Spring Cloud 集成提供支持
*/

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id)
    {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = payFeignApi.getPayInfo(id);
        return resultData;
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping(value = "/feign/pay/mylb")
    public String mylb()
    {
        return payFeignApi.mylb();
    }


}
