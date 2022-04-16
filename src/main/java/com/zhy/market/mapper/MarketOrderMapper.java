package com.zhy.market.mapper;

import com.zhy.market.domain.MarketOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketOrderMapper {

    @Select("select * from marketOrder")
    List<MarketOrder> getAllOrder();

    @Insert("insert into marketOrder(orderuuid,orderDate,orderaddress,goods,orderStatus,useruuid,username) values(#{orderuuid},#{orderDate},#{orderaddress},#{goods},#{orderStatus},#{useruuid},#{username})")
    Integer createOrder(@Param("orderuuid") String orderuuid, @Param("orderDate") String orderdate, @Param("orderaddress") String orderaddress, @Param("goods") String goods, @Param("orderStatus") Integer orderStatus, @Param("useruuid") String useruuid, @Param("username") String username);

    @Select("select * from marketOrder where useruuid=#{useruuid}")
    List<MarketOrder> getOrderByUserName(@Param("useruuid") String useruuid);

}
