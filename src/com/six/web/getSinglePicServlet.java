package com.six.web;

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

@WebServlet(name = "getSinglePicServlet",urlPatterns = "/getSinglePicServlet")
public class getSinglePicServlet extends HttpServlet {
    /**
     * 返回通过商品编号拿到的颜色名称
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        String goodId = request.getParameter("goodId");
        String color = " ";
        try {
            color = PictureDao.getPic(goodId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        System.out.println(color);
        out.print(color);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
