package com.springmvc.entity;

import java.util.Date;

public class Orders {
    private String userid;
    private String username;
    private Integer goodsId;
    private String goodsName;
    private String goodsType;
    private Float goodsPrice;
    private String goodsColor;
    private String goodsMessage;
    private String goodsFile;
    private String goodsTime;
    private Integer number;
    private String goodsStatus;
    public Orders() {
    }

    public Orders(String userid, String username, Integer goodsId, String goodsName, String goodsType, Float goodsPrice, String goodsColor, String goodsMessage, String goodsFile, String goodsTime, Integer number, String goodsStatus) {
        this.userid = userid;
        this.username = username;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsPrice = goodsPrice;
        this.goodsColor = goodsColor;
        this.goodsMessage = goodsMessage;
        this.goodsFile = goodsFile;
        this.goodsTime = goodsTime;
        this.number = number;
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
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

    public String getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(String goodsTime) {
        this.goodsTime = goodsTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsColor='" + goodsColor + '\'' +
                ", goodsMessage='" + goodsMessage + '\'' +
                ", goodsFile='" + goodsFile + '\'' +
                ", goodsTime=" + goodsTime +
                ", number=" + number +
                ", goodsStatus='" + goodsStatus + '\'' +
                '}';
    }
}
