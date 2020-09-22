package com.springmvc.dao;

import com.springmvc.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //获取订单信息
    List<Orders> showOrder(@Param("id") String id);

    //删除订单
    void deleteOrder(@Param("goodsId") Integer goodsId);

    //新增订单
    void addOrder(@Param("goodsId") Integer goodsId, @Param("userid")String userid,@Param("username") String username,@Param("goodsCount") String goodsCount,@Param("goodsColor") String goodsColor,@Param("goodsFile") String goodsFile,@Param("goodsName") String goodsName,@Param("goodsPrice") Float goodsPrice,@Param("goodsType") String goodsType,@Param("goodsMessage") String goodsMessage,@Param("goodsTime") String goodsTime);

    //查找是否用同一订单
    List<Orders> haveOrder(@Param("goodsId")Integer goodsId, @Param("userid")String userid);

    //将订单中的时间和状态修改
    void updateTime(@Param("goodsId")Integer goodsId, @Param("goodsTime")String goodsTime);
}