/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GainCartServlet
 * Author:   陆
 * Date:     2019/7/3 23:23
 * Description: 读取购物车的数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.Cart1;
import com.six.pojo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈读取购物车的数据〉
 *
 * @author 陆
 * @create 2019/7/3
 * @since 1.0.0
 */
@WebServlet(name = "GainCartServlet", urlPatterns = "/GainCartServlet")
public class GainCartServlet extends HttpServlet {
    @Override

    /**
     * 获取cart表中的数据返回给js
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
//        HttpSession session = req.getSession(true);
//        String id = (String)session.getAttribute("userId");

        List<Cart> list = new ArrayList<Cart>();
        try{
             list = Cart1.getGrartList("1");
            System.out.println("进入try！！！");
        }catch (Exception e){

        }

        String jsonString;
        jsonString = JSONObject.toJSONString(list);
        System.out.println(jsonString);
        PrintWriter out = resp.getWriter();
        out.println(jsonString);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


}