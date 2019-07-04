package com.six.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "doCartServlet",urlPatterns = "/doCartServlet")
public class doCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户id
        String userId = (String) request.getSession().getAttribute("userID");
        //获取颜色
        String color = request.getParameter("color");
        //获取版本
        String version = request.getParameter("ver");
        //获取数量
        String amount = request.getParameter("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
