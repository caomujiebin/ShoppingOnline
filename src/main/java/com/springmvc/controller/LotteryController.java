package com.springmvc.controller;

import com.springmvc.service.LotteryService;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/lottery")
public class LotteryController {
    @Autowired
    private UserService userService;

    //查看用户当前是否拥有优惠券
    @RequestMapping("/selectLottery")
    public String selectLottery(HttpServletRequest request, Model model){
        String userid=request.getParameter("userid");
        Integer haveLottery=userService.haveLottery(userid);
        System.out.println("rhe"+haveLottery);
        if(haveLottery!=0){
            model.addAttribute("flag","您的抽奖机会已用完，等优惠券过期或用掉再来领吧");
        }
        model.addAttribute("userid",userid);
        return "forward:/lottery.jsp";
    }
    //将优惠券保存在用户表中
    @RequestMapping("/saveLottery")
    public String saveLottery(HttpServletRequest request, Model model){
        String lotteryId=request.getParameter("lotteryId");
        String userid=request.getParameter("userid");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.MONTH,1);//在当前时间上加一个月当做过期时间
        String lotteryTime =sdf.format(cal.getTime());// new Date()为获取当前系统时间
        userService.updateLottery(Integer.valueOf(lotteryId)+1,lotteryTime,userid);
        System.out.println(Integer.valueOf(lotteryId)+1);
            model.addAttribute("flag","您的抽奖机会已用完，等优惠券过期或用掉再来领吧");
        model.addAttribute("userid",userid);
        return "forward:/lottery.jsp";
    }
}
