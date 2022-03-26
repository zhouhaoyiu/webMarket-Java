package com.zhy.market.domain;

import lombok.Data;

@Data
public class Goods {
   Integer goodId;
   String goodName;
   Integer goodClassification;
   Integer goodPrice;
   Integer goodCount;
   String goodImages;
   String goodDescribeImages;

}
