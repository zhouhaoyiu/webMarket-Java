package com.zhy.market.mapper;

import com.zhy.market.domain.MarketOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketOrderMapper {

   @Select("select * from marketOrder")
   List<MarketOrder> getAllOrder();

   @Insert("insert into marketOrder")
   Integer createOrder(MarketOrder order);
}
