package com.springmvc.service;
import com.springmvc.entity.Good;
import com.springmvc.entity.GoodCar;

import java.util.List;

public interface CarService {
    List<GoodCar> goodCar(String userid);
    void delgoodCar(Integer goodsId);

    List<GoodCar> showGood(Integer goodsId);

    void addgoodCarCount(Integer goodsId, Integer goodsCount);


    void addgoodCar(Integer goodsId, String userid, String username, String goodsColor, String goodsFile, String goodsName, Float goodsPrice, String goodsType, String goodsMessage,Integer goodsCount);
}
