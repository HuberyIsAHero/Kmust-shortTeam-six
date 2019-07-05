package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.Cart1;
import com.six.pojo.Picutre;

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

@WebServlet(name = "GainPicutreServlet",urlPatterns="/GainPicutreServlet")
public class GainPicutreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        System.out.println("进入GainPicutreServlet");
        HttpSession session = request.getSession(true);
        String id = (String)session.getAttribute("userId");
        String[] list ={};
        try{
          list = Cart1.getPicutre("1");
        }catch (Exception e){
            e.printStackTrace();
        }
        String jsonString;
        jsonString = JSONObject.toJSONString(list);
        System.out.println(jsonString);
        PrintWriter out = response.getWriter();
        out.println(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
