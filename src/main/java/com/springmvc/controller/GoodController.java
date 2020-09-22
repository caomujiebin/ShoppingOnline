package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.protocol.Resultset;
import com.springmvc.entity.Good;
import com.springmvc.entity.Lottery;
import com.springmvc.entity.Orders;
import com.springmvc.service.GoodService;
import com.springmvc.service.LotteryService;
import com.springmvc.service.OrderService;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private LotteryService lotteryService;
    //显示商品
    @RequestMapping(path="/showGood")
    public String showGood(Model model, HttpServletRequest request,@RequestParam(defaultValue="1") Integer currentPage) throws SQLException {
        //Object userid=request.getAttribute("id");
        PageHelper.startPage(currentPage,10);
        List<Good> goodlist= goodService.showAll();
        PageInfo<Good> pageInfo=new PageInfo<Good>(goodlist,10);//分页
        model.addAttribute("goodlist",pageInfo);
        return "forward:/MainSystem.jsp";
    }


    //待付款
    @RequestMapping(path="/purchase")
    public String purchase(Model model, HttpServletRequest request){
        Integer goodsId=Integer.valueOf(request.getParameter("goodsId"));
        String goodsCount=request.getParameter("good"+goodsId);
        String userid=request.getParameter("userid");
        Float goodsPrice = 0.0f;
        //从商品表里查找信息
        List<Good> goodView=goodService.showOneGood(Integer.valueOf(goodsId));
        goodsPrice=goodView.get(0).getGoodsPrice();
        //查看是否有相同且未付款的订单
        List<Orders> haveOrder=orderService.haveOrder(goodsId,userid);
        //如果没有相同订单，则新增一个订单，状态为待付款，否则使用原订单
        if(haveOrder.size()==0){
            String username=request.getParameter("username");
            String goodsColor=goodView.get(0).getGoodsColor();
            String goodsFile=goodView.get(0).getGoodsFile();
            String  goodsName =goodView.get(0).getGoodsName();
            String  goodsType=goodView.get(0).getGoodsType();
            String  goodsMessage=goodView.get(0).getGoodsMessage();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String goodsTime =sdf.format(new Date());// new Date()为获取当前系统时间
            //新增一个订单
            orderService.addOrder(goodsId,userid,username,goodsCount,goodsColor,goodsFile,goodsName,goodsPrice,goodsType,goodsMessage,goodsTime);

        }
        //查看是否有可用优惠券
        Integer lotteryId=userService.haveLottery(userid);
        Lottery lotteryReduce=null;
        if(lotteryId>0){//0代表没有优惠券
             lotteryReduce=lotteryService.getLotteryReduce(lotteryId);
            if(goodsPrice>=lotteryReduce.getLotteryFull()){
                model.addAttribute("LotteryMessage","您有一张"+lotteryReduce.getLotteryReduce()+"元优惠券待使用");
            model.addAttribute("lotteryMoney",lotteryReduce.getLotteryReduce());}
            else
                model.addAttribute("LotteryMessage","您没有可用优惠券");
        }
        else
            model.addAttribute("LotteryMessage", "您没有可用优惠券");
        model.addAttribute("goodsId",goodsId);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("goodsPrice",goodsPrice);
        return "forward:/user/myInformation";
    }

    //付款
    @RequestMapping(path="/payforMoney")
    public String payforMoney(Model model, HttpServletRequest request) throws SQLException {
               String userid=request.getParameter("userid");
                String password=request.getParameter("password");
                String goodsId=request.getParameter("goodid");
                String inputPassword=request.getParameter("inputPassword");
                String goodsCount=request.getParameter("goodsCount");
                String goodsPrice=request.getParameter("goodsPrice");
                String lotteryMoney=request.getParameter("lotteryMoney");
       if(inputPassword.equalsIgnoreCase(password)){
           //将订单中的时间和状态修改
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
           String goodsTime =sdf.format(new Date());// new Date()为获取当前系统时间
           orderService.updateTime(Integer.valueOf(goodsId),goodsTime);
           //判断用户金额是否充足
           Float userMoney=userService.selectMoney(userid);
           Float spendMoney=Integer.valueOf(goodsCount)*Float.valueOf(goodsPrice)-Float.valueOf(lotteryMoney);//需花费金额
           if(userMoney<spendMoney){
               //System.out.println("余额不足");
               model.addAttribute("Error","您的余额不足!");
               return "forward:/user/myInformation";
           }else{
               //修改用户金额并将优惠券从用户表删除
               userService.updateMoney(userid,spendMoney);
               //将商品的数量减去相应数量
               goodService.deleteCount(Integer.valueOf(goodsId),Integer.valueOf(goodsCount));
              //将优惠券从用户表删除
               //userService.deleteLottery(userid);
           }

       }else{
           model.addAttribute("Error","密码错误，支付失败!");
           return "forward:/user/myInformation";
       }
        return "forward:/orders/myOrder";
    }
}
