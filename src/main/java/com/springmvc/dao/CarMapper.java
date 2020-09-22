package com.springmvc.dao;

import com.springmvc.entity.Good;
import com.springmvc.entity.GoodCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    //获取购物车信息
    List<GoodCar> goodCar(@Param("userid") String userid);

    //删除购物车信息
    void delgoodCar(@Param("goodsId") Integer goodsId);

    //查询是否购物车里有这件商品
    List<GoodCar> showGood(@Param("goodsId") Integer goodsId);

    //将购物车中的商品加上相应的数目
    void addgoodCarCount(@Param("goodsId")Integer goodsId, @Param("goodsCount")Integer goodsCount);

    //将商品信息添加进购物车
    void addgoodCar(@Param("goodsId") Integer goodsId, @Param("userid") String userid,@Param("username") String username,@Param("goodsColor") String goodsColor,@Param("goodsFile") String goodsFile,@Param("goodsName") String goodsName,@Param("goodsPrice") Float goodsPrice,@Param("goodsType") String goodsType,@Param("goodsMessage") String goodsMessage,@Param("goodsCount") Integer goodsCount);
}
