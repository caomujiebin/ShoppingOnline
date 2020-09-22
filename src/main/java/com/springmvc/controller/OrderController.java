package com.springmvc.controller;

import com.springmvc.entity.Orders;
import com.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //显示钱包中的订单信息
    @RequestMapping(path="/showOrder")
    public String showOrder(Model model,HttpServletRequest request) {
        //获取用户id
        String id=request.getParameter("userid");
        //获取订单信息
        List<Orders> orderlist= orderService.showOrder(id);
        model.addAttribute("goodlist",orderlist);
        return "forward:/MyMoney.jsp";
    }

//显示订单
    @RequestMapping(path="/myOrder")
    public String myMoney(Model model, HttpServletRequest request){
        //获取用户id
        String userid=request.getParameter("userid");
        //获取订单信息
        List<Orders> orderlist= orderService.showOrder(userid);
        model.addAttribute("orderlist",orderlist);
        model.addAttribute("userid",userid);
        return "forward:/Order.jsp";
    }

    //删除订单
    @RequestMapping(path="/deleteOrder")
    public String deleteOrder(Model model, HttpServletRequest request) {
        //获取商品id
        String goodsId = request.getParameter("goodsId");
        //获取用户id
        String userid = request.getParameter("userid");
        orderService.deleteOrder(Integer.valueOf(goodsId));
        model.addAttribute("userid",userid);
        return "forward:/orders/myOrder";
    }
}
