package com.zhy.market.controller;


import com.zhy.market.domain.MarketOrder;
import com.zhy.market.mapper.MarketOrderMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.zhy.market.controller.utils.getJsonRes;

@RestController
@RequestMapping("order")
public class MarketOrderController {

    @Resource()
    private MarketOrderMapper marketOrderMapper;

    @GetMapping("getAllOrder")
    public Object getAllOrder() {

        List<MarketOrder> orderData = marketOrderMapper.getAllOrder();
        return getJsonRes(1, "获取订单信息成功", orderData);
    }

    @PostMapping("createOrder")
    public Object createOrder(@RequestBody MarketOrder order)
    {
        Integer res = marketOrderMapper.createOrder(order);
        if(res > 0 ){
            getJsonRes(1, "创建订息成功", null);
        }
        return  getJsonRes(0, "创建订息失败", null);;
    }

    @GetMapping("setOrderStatus")
    public Object setOrderStatus(HttpServletRequest request ){
        Integer orderStatus = Integer.valueOf(request.getParameter("orderStatus"));
        if(orderStatus == 1){
            String refuseReason = request.getParameter("refuseReason");
        }
        return null;
    }
}
