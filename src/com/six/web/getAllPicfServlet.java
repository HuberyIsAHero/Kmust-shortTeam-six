package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.PictureDao;

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

@WebServlet(name = "getAllPicfServlet",urlPatterns = "/getAllPicfServlet")
public class getAllPicfServlet extends HttpServlet {
    /**
     * 拿到底部大图
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String goodId = request.getParameter("goodId");
        List list = null;
        try {
            list = PictureDao.getAllPicF(goodId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        String jsonString = JSONObject.toJSONString(list);
        PrintWriter out = response.getWriter();
        System.out.println(jsonString);
        out.println(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
