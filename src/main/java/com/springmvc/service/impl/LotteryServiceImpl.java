package com.springmvc.service.impl;

import com.springmvc.dao.LotteryMapper;
import com.springmvc.dao.UserMapper;
import com.springmvc.entity.Lottery;
import com.springmvc.entity.User;
import com.springmvc.service.LotteryService;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lotteryService")
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryMapper lotteryMapper;


    @Override
    public Lottery getLotteryReduce(Integer lotteryId) {
        return lotteryMapper.getLotteryReduce(lotteryId);
    }
}
