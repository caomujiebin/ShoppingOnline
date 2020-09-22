package com.springmvc.dao;

import com.springmvc.entity.Lottery;
import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //登录
    User login(@Param("username") String username, @Param("password") String password);

    //获取用户id
    String getId(@Param("username") String username,@Param("password") String password);

    //获取用户余额
    float getRestMoney(@Param("id") String id);

    //获取个人信息
    List<User> showInformation(@Param("id") String id);

    //注册
    void register(@Param("id")String id,@Param("username")String username, @Param("password")String password,@Param("address")String address,@Param("telphone") String telphone);

    //查找用户余额
    Float selectMoney(@Param("id") String id);

   //修改用户金额
    void updateMoney(@Param("id") String id, @Param("money") Float money);

    //修改用户表中的优惠券
    void updateLottery(@Param("lotteryId") Integer lotteryId,@Param("lotteryTime") String lotteryTime,@Param("id") String id);

    //查看用户当前是否拥有优惠券
    Integer haveLottery(@Param("id")String id);

    //查看是否用户名已被注册
    String selectUsernameCount(@Param("username")String username);

    //查看是否有可用优惠券
    Integer selectLottery(@Param("id") String id);

    //将优惠券从用户表删除
    void deleteLottery(@Param("id") String id);
}