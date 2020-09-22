package com.springmvc.service.impl;
import com.springmvc.dao.OrderMapper;
import com.springmvc.entity.Orders;
import com.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> showOrder(String id){
        return orderMapper.showOrder(id);
    }

    @Override
    public void deleteOrder(Integer goodsId) {
         orderMapper.deleteOrder(goodsId);
    }

    @Override
    public void addOrder(Integer goodsId, String userid, String username, String goodsCount, String goodsColor, String goodsFile, String goodsName, Float goodsPrice, String goodsType, String goodsMessage,String goodsTime) {
        orderMapper.addOrder(goodsId,userid,username,goodsCount,goodsColor,goodsFile,goodsName,goodsPrice,goodsType,goodsMessage,goodsTime);
    }

    @Override
    public List<Orders> haveOrder(Integer goodsId, String userid) {
        return orderMapper.haveOrder(goodsId,userid);
    }

    @Override
    public void updateTime(Integer goodsId, String goodsTime) {
        orderMapper.updateTime(goodsId,goodsTime);
    }
}
