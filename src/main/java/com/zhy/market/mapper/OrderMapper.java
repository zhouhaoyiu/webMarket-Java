package com.zhy.market.mapper;

import com.zhy.market.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

   List<Order> getAllOrder();
}
