package com.springmvc.dao;

import com.springmvc.entity.Lottery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LotteryMapper {

    Lottery getLotteryReduce(@Param("lotteryId") Integer lotteryId);
}
