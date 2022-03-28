package com.zhy.market.controller;

import com.zhy.market.domain.UserLog;
import com.zhy.market.mapper.UserLogMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.zhy.market.controller.utils.getJsonRes;

@RequestMapping("userLog")
@RestController
public class UserLogController {
    @Resource
    private UserLogMapper userLogMapper;

    @PostMapping("addUserLog")
    public Object addUserLog(@RequestBody UserLog userLog) {
        Integer userUUid = Integer.valueOf(userLog.getUseruuid());
        String logDate = userLog.getLogdate();

        Integer res = userLogMapper.addUserLog();
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
