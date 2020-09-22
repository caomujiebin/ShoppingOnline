package com.springmvc.dao;

import com.springmvc.entity.Good;
import com.springmvc.entity.GoodCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoodMapper {
    //获取商品展示信息
    List<Good> showAll();

    //从商品表里查找信息
    List<Good> showOneGood(@Param("goodsId") Integer goodsId);

    //将商品的数量减去相应数量
    void deleteCount(@Param("goodsId") Integer goodsId, @Param("goodsCount") Integer goodsCount);
}