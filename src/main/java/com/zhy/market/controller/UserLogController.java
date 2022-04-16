package com.zhy.market.controller;

import com.zhy.market.domain.UserLog;
import com.zhy.market.mapper.UserLogMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.zhy.market.controller.utils.getJsonRes;

@RequestMapping("userLog")
@RestController
public class UserLogController {
    @Resource
    private UserLogMapper userLogMapper;

    @PostMapping("addUserLog")
    public Object addUserLog(@RequestBody UserLog userLog) {
        String loguuid = String.valueOf(UUID.randomUUID());
        Integer userid = Integer.valueOf(userLog.getUserid());
        String type = userLog.getType();
        Integer gid = userLog.getGid();
        String logtime = userLog.getLogtime();

        Integer res = userLogMapper.addUserLog(loguuid, userid, type, gid, logtime);
        if (res > 0) {
            return getJsonRes(0, "添加访问日志成功", null);
        }
        return getJsonRes(1, "添加访问日志成失败", null);
    }


    @GetMapping("getAllUserLog")
    public Object getAllUserLog() {
        List<UserLog> data = userLogMapper.getAllUserLog();
        return getJsonRes(0, "获取成功", data);
    }

}
