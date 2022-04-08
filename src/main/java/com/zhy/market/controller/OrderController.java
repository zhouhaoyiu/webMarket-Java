package com.zhy.market.controller;


import com.zhy.market.domain.Order;
import com.zhy.market.mapper.OrderMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.zhy.market.controller.utils.getJsonRes;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource()
    private OrderMapper orderMapper;

    @GetMapping("getAllOrder")
    public Object getAllOrder() {

        List<Order> orderData = orderMapper.getAllOrder();
        return getJsonRes(1, "获取订单信息成功", orderData);
    }
}
