package com.springmvc.service;

import com.springmvc.entity.Good;

import java.sql.SQLException;
import java.util.List;

public interface GoodService {
   List<Good> showAll() throws SQLException;

    List<Good> showOneGood(Integer goodsId);

    void deleteCount(Integer goodsId, Integer goodsCount);
}
