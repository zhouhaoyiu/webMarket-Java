package com.zhy.market.mapper;


import com.zhy.market.domain.AdminLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminLogMapper {

    @Insert("insert into adminLog(adminLogUUid, adminUUid, logTime )values ( #{adminLogUUid}, #{adminUUid}, #{logTine}) ")
    Integer addAdminLog(@Param("adminLogUUid") String adminLogUUid, @Param("adminUUid") String adminUUid, @Param("logTime") String logTime);

    @Select("select * from adminLog")
    List<AdminLog> getAllAdminLog();
}
