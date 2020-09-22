package com.springmvc.entity;

public class User {
    private String id;//id

    private String username;//用户名

    private String password;//密码

    private Float money;//余额

    private String telphone;//电话

    private String status;//身份

    private String address;//地址

    private Integer lotteryId;//优惠券Id
    private String lotteryTime;//优惠券过期时间

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, String telphone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telphone = telphone;
        this.address = address;
    }

    public User(String id, String username, String password, Float money, String telphone, String status, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
        this.telphone = telphone;
        this.status = status;
        this.address = address;
    }

    public User(String id, String username, String password, Float money, String telphone, String status, String address, Integer lotteryId, String lotteryTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
        this.telphone = telphone;
        this.status = status;
        this.address = address;
        this.lotteryId = lotteryId;
        this.lotteryTime = lotteryTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(String lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", telphone='" + telphone + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", lotteryId=" + lotteryId +
                ", lotteryTime='" + lotteryTime + '\'' +
                '}';
    }
}