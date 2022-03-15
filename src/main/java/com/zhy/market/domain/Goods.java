package com.zhy.market.domain;

import lombok.Data;

@Data
public class Goods {
  public Integer goodId;
  public String goodName;
  public Integer goodClassification;
  public Integer goodPrice;
  public Integer goodCount;
  public String goodImages;
  public String goodDescribeImages;

}
