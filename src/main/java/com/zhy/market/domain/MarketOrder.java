package com.zhy.market.domain;

import lombok.Data;

@Data
public class MarketOrder {
    public Integer orderid;
    public String orderdate;
    public String goods;
    public Integer orderStatus;
    public String useruuid;
    public String username;
}
