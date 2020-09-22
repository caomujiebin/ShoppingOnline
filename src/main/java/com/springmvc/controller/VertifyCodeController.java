package com.springmvc.controller;

import com.mysql.cj.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
@Controller
@RequestMapping("/vertify")
public class VertifyCodeController extends HttpServlet {
    // 1. 写一个方法随机获取颜色
    public Color randomColor(){
        // r g b 取值范围 0到255
        Random random = new Random();
        return new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }
    @RequestMapping("/VertifyCode")
public void VertifyCode(HttpServletResponse response, HttpSession session,Model model) throws IOException {
    // 2. 创建缓存图片：指定宽width=90，高 height=30
    int width = 90;
    int height = 30;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // 3. 获取画笔对象
    Graphics g = image.getGraphics();

    // 4. 设置画笔颜色，并且填充矩形区域
    g.setColor(Color.white);
    g.fillRect(0, 0, width, height);

    // 5. 从字符数组中随机得到字符
    char[] arr = { 'A', 'B', 'C', 'D','E' ,'F','G','H','I','J','K','L','M','N','R','O','Q','R','S','T','U','V','W','X','Y','Z',
            'a', 'b', 'c', 'd','e' ,'f','g','h','i','j','k','l','m','n','r','o','q','r','s','t','u','n','w','x','y','z',
            '1', '2', '3', '4','5','6','7','8','9' };
    // 创建随机对象
    Random r = new Random();
    //验证码字符串
        String vertify="";
    for (int i = 0; i < 4; i++) {
        // 随机产生一个索引值
        int index = r.nextInt(arr.length);
        // 根据索引获得随机字符
        char ch = arr[index];
        vertify+=ch;
        // 设置字体，大小为 18
        g.setFont(new Font(Font.DIALOG,Font.BOLD + Font.ITALIC,18));
        // 设置字的颜色随机
        g.setColor(randomColor());

        // 绘制字符串
        // 7. 将每个字符画到图片上，位置：
        int x = 5 + (i*20);
        int y = 20;
        g.drawString(String.valueOf(ch),x,y);
    }

    // 8. 画10条干扰线，线的位置是随机的，x 范围在 width 之中，y 的范围在 height 之中。
    for (int i = 0; i < 20; i++) {
        // 设置颜色随机
        g.setColor(randomColor());
        int x1 = r.nextInt(width + 1);
        int x2 = r.nextInt(height + 1);
        int y1 = r.nextInt(width + 1);
        int y2 = r.nextInt(height + 1);
        g.drawLine(x1,y1,x2,y2);
    }

    // 9. 将缓存的图片输出到响应输出流中
    ImageIO.write(image, "png", response.getOutputStream());
   // model.addAttribute("vertifycode","123456");
        session.setAttribute("vertifycode",vertify);
}

}
