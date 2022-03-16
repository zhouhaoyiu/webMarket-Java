package com.zhy.market.domain;


import lombok.Data;

@Data
public class GoodsClassification {
    public Integer classificationId;
    public String classificationName;
    public Integer parentId;
}
