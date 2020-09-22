package com.springmvc.controller;

import com.springmvc.entity.Good;
import com.springmvc.entity.GoodCar;
import com.springmvc.service.CarService;
import com.springmvc.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
//商品ewa
    @Autowired
    private GoodService goodService;
    //显示购物车
    @RequestMapping(path="/goodCar")
    public String goodCar(Model model, HttpServletRequest request){
        String userid=request.getParameter("userid");
        List<GoodCar> goodCarlist= carService.goodCar(userid);
        //获取购物车信息
        model.addAttribute("userid",userid);
        model.addAttribute("goodCarlist",goodCarlist);
        return "forward:/GoodCar.jsp";
    }

    //删除一件购物车商品
    @RequestMapping(path="/delgoodCar")
    public String delgoodCar(Model model, HttpServletRequest request){
        String goodsId=request.getParameter("goodsId");
        String userid=request.getParameter("userid");
        carService.delgoodCar(Integer.valueOf(goodsId));
        model.addAttribute("userid",userid);
        return "forward:/car/goodCar";
    }

    //添加购物车
    @RequestMapping(path="/addgoodsCar")
    public String addgoodsCar(Model model, HttpServletRequest request) throws SQLException {
        String goodsId=request.getParameter("goodsId");
        String userid=request.getParameter("userid");
        String username=request.getParameter("username");
        String goodsCount=request.getParameter("car"+goodsId);
        //从商品表里查找信息
        List<Good> goodView=goodService.showOneGood(Integer.valueOf(goodsId));
        String goodsColor=goodView.get(0).getGoodsColor();
        String goodsFile=goodView.get(0).getGoodsFile();
        String  goodsName =goodView.get(0).getGoodsName();
        Float  goodsPrice=goodView.get(0).getGoodsPrice();
        String  goodsType=goodView.get(0).getGoodsType();
        String  goodsMessage=goodView.get(0).getGoodsMessage();
        //将商品信息添加进购物车
        List<GoodCar> num=carService.showGood(Integer.valueOf(goodsId));
        if(num.size()>0){
            //将购物车中的商品加上相应的数目
            carService.addgoodCarCount(Integer.valueOf(goodsId),Integer.valueOf(goodsCount));
        }else{
            carService.addgoodCar(Integer.valueOf(goodsId),userid,username,goodsColor,goodsFile,goodsName,goodsPrice,goodsType,goodsMessage,Integer.valueOf(goodsCount));
        }

        model.addAttribute("id",userid);
        return "forward:/good/showGood";
    }
}
