package com.zhy.market.mapper;


import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsClassification {

    @Insert("INSERT")
    Integer addClassification();
}
