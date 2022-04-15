package com.zhy.market.domain;

import lombok.Data;

/**
 * @author zhy
 * */
@Data
public class UserLog {
    /**
     * @Param logid 日志id
     *
     */
    Integer logid;
    Integer userid;
    String type;
    Integer gid;
    String logdate;
}
