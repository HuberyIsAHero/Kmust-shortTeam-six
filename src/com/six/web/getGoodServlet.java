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
import java.util.List;

@WebServlet(name = "getGoodServlet",urlPatterns = "/getGoodServlet")
public class getGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        List<Good> result = null;
        try {
            result = GoodDao.getGoodList();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        //封装json
        String jsonString = JSONObject.toJSONString(result);
        PrintWriter out = response.getWriter();
        //System.out.println(jsonString);
        out.println(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
