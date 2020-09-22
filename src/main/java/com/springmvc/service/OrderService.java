package com.springmvc.service;

import com.springmvc.entity.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> showOrder(String id);

    void deleteOrder(Integer goodsId);

    void addOrder(Integer goodsId, String userid, String username, String goodsCount, String goodsColor, String goodsFile, String goodsName, Float goodsPrice, String goodsType, String goodsMessage,String goodsTime);

    List<Orders> haveOrder(Integer goodsId, String userid);

    void updateTime(Integer goodsId, String goodsTime);

}
