package com.springmvc.service.impl;

import com.springmvc.dao.UserMapper;
import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User users = userMapper.login(username, password);
        return  users!=null;
    }

    @Override
    public String getId(String username, String password) {
        return userMapper.getId(username,password);
    }

    @Override
    public float getRestMoney(String id) {
        return userMapper.getRestMoney(id);
    }

    @Override
    public List<User> showInformation(String id) {
        return userMapper.showInformation(id);
    }

    @Override
    public void register(String id, String username, String password,String address, String telphone) {
        userMapper.register(id,username,password,address,telphone);
    }

    @Override
    public Float selectMoney(String id) {
        return userMapper.selectMoney(id);
    }

    @Override
    public void updateMoney(String userid, Float spendMoney) {
        userMapper.updateMoney(userid,spendMoney);
    }

    @Override
    public void updateLottery(Integer lotteryId, String lotteryTime, String userid) {
        userMapper.updateLottery(lotteryId,lotteryTime,userid);
    }

    @Override
    public Integer haveLottery(String userid) {
        return userMapper.haveLottery(userid);
    }

    @Override
    public String selectUsernameCount(String username) {
        return userMapper.selectUsernameCount(username);
    }

    @Override
    public Integer selectLottery(String userid) {
        return userMapper.selectLottery(userid);
    }

    @Override
    public void deleteLottery(String userid) {
         userMapper.deleteLottery(userid);
    }
}
