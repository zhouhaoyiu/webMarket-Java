package com.zhy.market.controller;


import com.zhy.market.domain.MarketInfo;
import com.zhy.market.mapper.MarketInfoMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("marketInfo")
public class MarketInfoController {

    @Resource
    private MarketInfoMapper marketInfoMapper;

    @GetMapping("getMarketInfo")
    public Object getMarketInfo(){

        List<MarketInfo> info = marketInfoMapper.getMarketInfo();

        JSONObject json = new JSONObject();
        json.put("data",info);
        return json;
    }

    @PostMapping("setMarketInfo")
    public Object setMarketInfo(@RequestBody MarketInfo marketInfo){

        return null;
    }

}
