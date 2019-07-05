package com.six.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.six.dao.JdbcUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/ServletOrder")
public class ServletOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String getSessionUserName = "1";
        getSessionUserName = (String) session.getAttribute("userID");
        JSONArray jsonArray = new JSONArray();
        try{
            JdbcUntil jdbcUntil = new JdbcUntil();
            String sql = "select * from tb_order where userId = ?";
            jdbcUntil.pstm = jdbcUntil.con.prepareStatement(sql);
            jdbcUntil.pstm .setString(1,getSessionUserName);
            System.out.println(getSessionUserName);
            ResultSet res = jdbcUntil.sysExecuteQuery();
            while (res.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("orderId",res.getString(1));
                jsonObject.put("goodId",res.getString(2));
                jsonObject.put("userId",res.getString(3));
                jsonObject.put("receiverId",res.getString(4));
                jsonObject.put("zhiFuFangShi",res.getString(5));
                jsonObject.put("dingDanJinE",res.getString(6));
                jsonObject.put("xiaDanShiJian",res.getString(7));
                jsonObject.put("dingDanZhuangTai",res.getString(8));
                jsonArray.add(jsonObject);
            }
            jdbcUntil.closeAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        String JsonString = jsonArray.toJSONString();
        System.out.println(JsonString);
        PrintWriter out = response.getWriter();
        out.println(JsonString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
