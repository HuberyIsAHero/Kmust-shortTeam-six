package com.six.web;

import com.mysql.cj.protocol.Resultset;
import com.six.dao.JdbcUntil;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "doCartServlet",urlPatterns = "/doCartServlet")
public class doCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取用户id
//        String userId = (String) request.getSession().getAttribute("userID");
        String userId = "1234";
        //获取商品编号
        String goodId = request.getParameter("goodId");
        //获取颜色
        String color = request.getParameter("color");
        //获取版本
        String version = request.getParameter("ver");
        //获取数量
        String amount = request.getParameter("amount");
       // System.out.println(userId+' '+goodId+' '+color+' '+version+' '+amount);
        //直接入库
        try {
            JdbcUntil myl = new JdbcUntil();
            ResultSet res = null;
            res = myl.query("select * from tb_goods where goodId=\""+goodId+"\"");
            String goodName = "",danJia = "";
            while (res.next()){
                goodName = res.getString("shangPinMingCheng");
                danJia = res.getString("benDianJia");
            }
            String sql = "insert into tb_cart values(?,?,?,?,?,?,?)";
            myl.pstm = myl.con.prepareStatement(sql);
            myl.pstm.setString(1,userId);
            myl.pstm.setString(2,goodId);
            myl.pstm.setString(3,goodName);
            myl.pstm.setString(4,color);
            myl.pstm.setString(5,version);
            myl.pstm.setString(6,danJia);
            myl.pstm.setString(7,amount);
            myl.pstm.executeUpdate();
            //关闭数据库
            myl.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("flow1.html").forward(request,response);
    }
}
