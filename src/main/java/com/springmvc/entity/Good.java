package com.springmvc.entity;

public class Good {
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Float goodsPrice;
    private  String goodsColor;
    private String goodsMessage;
    private Float goodsNoprice;
    private String goodsFile;
    private String userid;
    private Integer goodsCount;

    public Good() {
    }

    public Good(Integer goodsId, String goodsName, String goodsType, Float goodsPrice, String goodsColor, String goodsMessage, Float goodsNoprice, String goodsFile, String userid, Integer goodsCount) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsPrice = goodsPrice;
        this.goodsColor = goodsColor;
        this.goodsMessage = goodsMessage;
        this.goodsNoprice = goodsNoprice;
        this.goodsFile = goodsFile;
        this.userid = userid;
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public String getGoodsMessage() {
        return goodsMessage;
    }

    public void setGoodsMessage(String goodsMessage) {
        this.goodsMessage = goodsMessage;
    }

    public Float getGoodsNoprice() {
        return goodsNoprice;
    }

    public void setGoodsNoprice(Float goodsNoprice) {
        this.goodsNoprice = goodsNoprice;
    }

    public String getGoodsFile() {
        return goodsFile;
    }

    public void setGoodsFile(String goodsFile) {
        this.goodsFile = goodsFile;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsColor='" + goodsColor + '\'' +
                ", goodsMessage='" + goodsMessage + '\'' +
                ", goodsNoprice=" + goodsNoprice +
                ", goodsFile='" + goodsFile + '\'' +
                ", userid='" + userid + '\'' +
                ", goodsCount=" + goodsCount +
                '}';
    }
}