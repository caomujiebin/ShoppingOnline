package com.springmvc.service;

import com.springmvc.entity.User;

import java.util.List;

public interface UserService {
    boolean login(String username, String password);

    String getId(String username, String password);

    float getRestMoney(String id);

    List<User> showInformation(String id);

    void register(String id, String username,  String password,String address, String telphone);

    Float selectMoney(String userid);

    void updateMoney(String userid, Float spendMoney);

    void updateLottery(Integer lotteryId, String lotteryTime, String userid);

    Integer haveLottery(String userid);

    String selectUsernameCount(String username);

    Integer selectLottery(String userid);

    void deleteLottery(String userid);
}
