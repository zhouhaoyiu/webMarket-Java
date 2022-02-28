package com.zhy.market.mapper;

import com.zhy.market.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user where userName=#{userName}")
    List<User> userInfo(@Param("userName")String userName);
}
