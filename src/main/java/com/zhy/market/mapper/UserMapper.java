package com.zhy.market.mapper;

import com.zhy.market.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user where username=#{userName}")
    List<User> userLogin(@Param("userName") String userName);

    @Insert("insert into user(username,password) values(#{username},#{password} )")
    Integer userRegis(@Param("username") String username, @Param("password") String password, @Param("address") String address, @Param("phonenumber") Integer phonenumber, @Param("useruuid") String useruuid);

//    List<User> userLogin(String username);
}
