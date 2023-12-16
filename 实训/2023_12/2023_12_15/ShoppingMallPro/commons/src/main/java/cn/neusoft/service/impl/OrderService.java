package cn.neusoft.service.impl;

import cn.neusoft.mapper.OrderMapper;
import cn.neusoft.po.Order;
import cn.neusoft.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
