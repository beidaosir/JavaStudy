package com.beidao.mall.order.controller;

import com.beidao.mall.model.dto.h5.OrderInfoDto;
import com.beidao.mall.model.vo.common.Result;
import com.beidao.mall.model.vo.common.ResultCodeEnum;
import com.beidao.mall.model.vo.h5.TradeVo;
import com.beidao.mall.order.service.OrderInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "订单管理")
@RestController
@RequestMapping(value="/api/order/orderInfo")
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderInfoController {
   
   @Autowired
   private OrderInfoService orderInfoService;


   //生成订单
   @Operation(summary = "提交订单")
   @PostMapping("auth/submitOrder")
   public Result<Long> submitOrder(@RequestBody OrderInfoDto orderInfoDto) {
      Long orderId = orderInfoService.submitOrder(orderInfoDto);
      return Result.build(orderId, ResultCodeEnum.SUCCESS);
   }



   @Operation(summary = "确认下单")
   @GetMapping("auth/trade")
   public Result<TradeVo> trade() {
      TradeVo tradeVo = orderInfoService.getTrade();
      return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
   }

}