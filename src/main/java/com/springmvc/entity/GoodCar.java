package com.springmvc.entity;

public class GoodCar {
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Float goodsPrice;
    private  String goodsColor;
    private String goodsMessage;
    private String goodsFile;
    private String userid;
    private String username;
    private Integer goodsCount;

    public GoodCar() {
    }

    public GoodCar(Integer goodsId, String goodsName, String goodsType, Float goodsPrice, String goodsColor, String goodsMessage, String goodsFile, String userid, String username, Integer goodsCount) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsPrice = goodsPrice;
        this.goodsColor = goodsColor;
        this.goodsMessage = goodsMessage;
        this.goodsFile = goodsFile;
        this.userid = userid;
        this.username = username;
        this.goodsCount = goodsCount;
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

    public String getGoodsFile() {
        return goodsFile;
    }

    public void setGoodsFile(String goodsFile) {
        this.goodsFile = goodsFile;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "GoodCar{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsColor='" + goodsColor + '\'' +
                ", goodsMessage='" + goodsMessage + '\'' +
                ", goodsFile='" + goodsFile + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
