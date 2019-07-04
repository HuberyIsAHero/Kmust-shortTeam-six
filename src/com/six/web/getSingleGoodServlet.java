package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.GoodDao;
import com.six.pojo.Good;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getSingleGoodServlet",urlPatterns = "/getSingleGoodServlet")
public class getSingleGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("进来servlet啦。。");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String goodId = request.getParameter("goodId");
        Good good = null;
        try {
            good = GoodDao.getGood(goodId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        String jsonString = JSONObject.toJSONString(good);
        PrintWriter out = response.getWriter();
        //System.out.println(jsonString);
        out.println(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
