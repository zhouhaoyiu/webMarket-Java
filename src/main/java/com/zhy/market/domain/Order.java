package com.zhy.market.domain;

import lombok.Data;

@Data
public class Order {
    public Integer orderid;
    public String orderdate;
    public Integer goodid;
    public Integer ordernumber;
    public String useruuid;
    public String username;
}
