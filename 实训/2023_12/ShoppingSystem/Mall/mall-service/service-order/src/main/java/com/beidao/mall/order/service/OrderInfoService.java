package com.beidao.mall.order.service;

import com.beidao.mall.model.dto.h5.OrderInfoDto;
import com.beidao.mall.model.vo.h5.TradeVo;

public interface OrderInfoService {


    //确认下单
    TradeVo getTrade();


    //生成订单
    Long submitOrder(OrderInfoDto orderInfoDto);
}
