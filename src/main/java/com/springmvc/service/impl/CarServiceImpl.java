package com.springmvc.service.impl;

import com.springmvc.dao.CarMapper;
import com.springmvc.entity.Good;
import com.springmvc.entity.GoodCar;
import com.springmvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
   private CarMapper carMapper;
    @Override
    public List<GoodCar> goodCar(String userid) {
        return carMapper.goodCar(userid);
    }

    @Override
    public void delgoodCar(Integer goodsId) {
        carMapper.delgoodCar(goodsId);
    }

    @Override
    public List<GoodCar> showGood(Integer goodsId) {
        return carMapper.showGood(goodsId);
    }

    @Override
    public void addgoodCarCount(Integer goodsId, Integer goodsCount) {
        carMapper.addgoodCarCount(goodsId,goodsCount);
    }

    @Override
    public void addgoodCar(Integer goodsId, String userid, String username, String goodsColor, String goodsFile, String goodsName, Float goodsPrice, String goodsType, String goodsMessage,Integer goodsCount) {
        carMapper.addgoodCar(goodsId,userid,username,goodsColor,goodsFile,goodsName,goodsPrice,goodsType,goodsMessage,goodsCount);
    }


}
