package com.zhy.market.domain;

import lombok.Data;

@Data
public class Goods {
    Integer goodId;
    String goodName;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodClassification() {
        return goodClassification;
    }

    public void setGoodClassification(Integer goodClassification) {
        this.goodClassification = goodClassification;
    }

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodImages() {
        return goodImages;
    }

    public void setGoodImages(String goodImages) {
        this.goodImages = goodImages;
    }

    public String getGoodDescribeImages() {
        return goodDescribeImages;
    }

    public void setGoodDescribeImages(String goodDescribeImages) {
        this.goodDescribeImages = goodDescribeImages;
    }

    Integer goodClassification;
    Integer goodPrice;
    Integer goodCount;
    String goodImages;
    String goodDescribeImages;

}
