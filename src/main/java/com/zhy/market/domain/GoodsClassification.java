package com.zhy.market.domain;


import lombok.Data;

@Data
public class GoodsClassification {
     Integer classificationId;
     String classificationName;
     Integer parentId;
}
