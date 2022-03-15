package com.zhy.market.mapper;

import com.zhy.market.domain.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

  @Insert("insert into goods(goodName,goodClassification,goodPrice,goodCount,goodImages,goodDescribeImages) values(#{goodName},#{goodClassification},#{goodPrice},#{goodCount},#{goodImages},#{goodDescribeImages})")
  Integer addGood(@Param("goodName") String goodName, @Param("goodClassification") Integer goodClassification,
          @Param("goodPrice") Integer goodPrice, @Param("goodCount") Integer goodCount,
          @Param("goodImages") String goodImages, @Param("goodDescribeImages") String goodDescribeImages);

  @Select("select * from goods")
  List<Goods> getAllGoods();
}
