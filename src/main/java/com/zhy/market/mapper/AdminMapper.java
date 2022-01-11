package com.zhy.market.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.zhy.market.domain.Admin;

@Repository
public interface AdminMapper {
    @Insert("")
    List<Admin> getAllAdminsInfo();

    @Select({})
    Integer login(String userName, String passWord);

    int adminRegis(String userName, String passWord, String emailAddress, String phoneNumber, String string, int role);

    int checkUserName(String userName);

}
