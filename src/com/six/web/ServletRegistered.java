package com.six.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.six.dao.JdbcUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/ServletRegistered")
public class ServletRegistered extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String userName = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String Mail = request.getParameter("Mail");
        JSONArray jsonArray = new JSONArray();
        boolean stateUserName = true;
        int rows = 0;
        int count = 0;
        try{
            JdbcUntil until = new JdbcUntil();
            String sql = "select * from tb_user where userName = ?";
            until.pstm = until.con.prepareStatement(sql);
            until.pstm .setString(1,userName);
            System.out.println(userName);
            ResultSet res = until.sysExecuteQuery();
            while (res.next()){
                count++;
                if(count > 0){
                    stateUserName = false;
                    break;
                }
            }
            if (stateUserName){
                String sql1 = "INSERT into tb_user (userName,userPassword,userSex,userBirth,userMail) VALUES(?,?,?,?,?)";
                until.pstm = until.con.prepareStatement(sql1);
                until.pstm.setString(1,userName);
                until.pstm.setString(2,password1);
                until.pstm.setString(3,sex);
                until.pstm.setString(4,birthday);
                until.pstm.setString(5,Mail);
                rows = until.sysExecuteUpdate();
                until.closeAll();
                if(rows > 0){

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Message","恭喜,注册成功");
                    jsonArray.add(jsonObject);
                    String JsonString = jsonArray.toJSONString();
                    System.out.println(JsonString);
                    PrintWriter out = response.getWriter();
                    out.println(JsonString);
                }
            }else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Message","很遗憾,注册失败，用户名存在");
                jsonArray.add(jsonObject);
                String JsonString = jsonArray.toJSONString();
                System.out.println(JsonString);
                PrintWriter out = response.getWriter();
                out.println(JsonString);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
