package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ServletContext context;

    //查看是否用户名已被注册
    @RequestMapping("/haveUsername")
    public void haveUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 获得字符打印流
        PrintWriter out = response.getWriter();
        String username=request.getParameter("username");
        String count=userService.selectUsernameCount(username);
       if(!"".equalsIgnoreCase(count)&&count!=null){
           out.println("用户名已存在");
       }
    }

    //显示页面信息
    //请求转发
    @RequestMapping(path="/testRedirect")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //获取输入的验证码
        String vcode=request.getParameter("vcode");
        HttpSession session=request.getSession();
        //获取验证码
        String vertifycode=(String)session.getAttribute("vertifycode");
        boolean flag=false;//登录成功标识符
        if(vertifycode.equalsIgnoreCase(vcode)){
             flag= userService.login(username,password);
        }else{
            model.addAttribute("error","验证码错误！");
            return "forward:/index.jsp";
        }
        if(flag){
            //显示在线人数
            Integer count = (Integer) context.getAttribute("Count");
            //将在线人数+1
            if(count==null){
                context.setAttribute("Count", 1);
            }else
                context.setAttribute("Count", count+1);

            //判断是否选中记住我
            String rememberMe=request.getParameter("remember");
            if(rememberMe!=null){
                //将账号密码保存在cookie中
                Cookie userCookie=new Cookie("username",username);
                userCookie.setMaxAge(7*24*3600);
                userCookie.setPath(request.getContextPath()+"/");
                response.addCookie(userCookie);
                Cookie upassCookie=new Cookie("password",password);
                upassCookie.setMaxAge(7*24*3600);
                upassCookie.setPath(request.getContextPath()+"/");
                response.addCookie(upassCookie);
            }

            String id=userService.getId(username,password);
            model.addAttribute("id",id);
            model.addAttribute("username",username);
            session.setAttribute("username",username);//将username保存到会话域中
            return "forward:/good/showGood";
        }
        else{
            User user=new User(username,password);
            request.setAttribute("user",user);
            model.addAttribute("error","账号或密码错误！");
            return "forward:/index.jsp";
        }
    }

    //显示余额
    @RequestMapping(path="/myMoney")
    public String myMoney(Model model, HttpServletRequest request){
        String userid=request.getParameter("userid");
        //显示余额
        float restMoney= userService.getRestMoney(userid);
        model.addAttribute("restMoney",restMoney);
        return "forward:/orders/showOrder";
    }

    //显示个人信息
    @RequestMapping(path="/myInformation")
    public String myInformation(Model model, HttpServletRequest request){
        String userid=request.getParameter("userid");
        Object goodsId=request.getAttribute("goodsId");
        Object goodsPrice=request.getAttribute("goodsPrice");
        List<User> userlist= userService.showInformation(userid);
        model.addAttribute("userlist",userlist);
        model.addAttribute("goodsId",goodsId);
        model.addAttribute("userid",userid);
        model.addAttribute("goodsPrice",goodsPrice);
        return "forward:/MyInformation.jsp";
    }
    //注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request,Model model){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String telphone=request.getParameter("telphone");
        String id=randomString(username);
        userService.register(id,username,password,address,telphone);
        return "forward:/index.jsp";
    }

    //生成随机字符串
    public String randomString(String username){
        String str="0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder(username);
        for(int i=0;i<8;i++){
            int number=random.nextInt(9);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
