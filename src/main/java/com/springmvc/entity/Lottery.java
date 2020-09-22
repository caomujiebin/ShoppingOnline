package com.springmvc.entity;

public class Lottery {
    private Integer lotteryId;
    private Float lotteryFull;
    private Float lotteryReduce;
    private String lotteryFile;

    public Lottery() {
    }

    public Lottery(Integer lotteryId, Float lotteryFull, Float lotteryReduce, String lotteryFile) {
        this.lotteryId = lotteryId;
        this.lotteryFull = lotteryFull;
        this.lotteryReduce = lotteryReduce;
        this.lotteryFile = lotteryFile;
    }

    public Integer getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Float getLotteryFull() {
        return lotteryFull;
    }

    public void setLotteryFull(Float lotteryFull) {
        this.lotteryFull = lotteryFull;
    }

    public Float getLotteryReduce() {
        return lotteryReduce;
    }

    public void setLotteryReduce(Float lotteryReduce) {
        this.lotteryReduce = lotteryReduce;
    }

    public String getLotteryFile() {
        return lotteryFile;
    }

    public void setLotteryFile(String lotteryFile) {
        this.lotteryFile = lotteryFile;
    }


    @Override
    public String toString() {
        return "Lottery{" +
                "lotteryId=" + lotteryId +
                ", lotteryFull='" + lotteryFull + '\'' +
                ", lotteryReduce='" + lotteryReduce + '\'' +
                ", lotteryFile='" + lotteryFile + '\'' +
                '}';
    }
}
