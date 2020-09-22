package com.springmvc.service.impl;

import com.springmvc.dao.GoodMapper;
import com.springmvc.entity.Good;
import com.springmvc.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("goodService")
public class GoodServiceImpl implements GoodService{

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> showAll() throws SQLException {
        return goodMapper.showAll();
    }

    @Override
    public List<Good> showOneGood(Integer goodsId) {
        return goodMapper.showOneGood(goodsId);
    }

    @Override
    public void deleteCount(Integer goodsId, Integer goodsCount) {
        goodMapper.deleteCount(goodsId,goodsCount);
    }

}
