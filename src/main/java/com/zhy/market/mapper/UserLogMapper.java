package com.zhy.market.mapper;


import com.zhy.market.domain.UserLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogMapper {
    @Insert("insert into userLog")
    Integer addUserLog(String loguuid, Integer userid, String type, Integer gid, String logtime);

    @Select("select * from userLog")
    List<UserLog> getAllUserLog();
}
