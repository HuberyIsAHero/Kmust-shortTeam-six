package com.six.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.six.dao.JdbcUntil;
import com.six.until.DBUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 吴昌卓
 * 登录窗口
 * 版本 1.0
 * 时间 2019.7.3
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String getCookieUserPwd = null;
        String getCookieUserName = null;
        JSONArray js = new JSONArray();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String tString = cookie.getName();
                if (tString.equals("userNameSix"))
                {
                    getCookieUserName = cookie.getValue();
                }
                if (tString.equals("passWordSix")) {
                    getCookieUserPwd = cookie.getValue();
                }
            }
        }
        if (getCookieUserName != null && getCookieUserPwd != null){
      //      if(getCookieUserName.equals(userName)){
       //         if (getCookieUserPwd.equals(passWord)){
                    JSONObject JO = new JSONObject();
                    JO.put("message","登录成功");
//                    JO.put("userName",getCookieUserName);
                    js.add(JO);
           //         }
            //    }
            String jsonString = js.toString();
            System.out.println(jsonString);
            PrintWriter out = response.getWriter();
            out.println(jsonString);
        }else if(userName != null && passWord != null) {
            try {
                JdbcUntil jdbcUntil = new JdbcUntil();
                String sql = "select * from tb_user";
                ResultSet res = jdbcUntil.query(sql);
                while (res.next()) {
                    if (res.getString(2).equals(userName)) {
                        if (res.getString(3).equals(passWord)) {
                            JSONObject JO = new JSONObject();
                            JO.put("message", "登录成功");
                            js.add(JO);
                            //用户登录成功后验证发送cookie到浏览器
                            Cookie Name = new Cookie("userNameSix", userName);
                            Cookie Pwd = new Cookie("passWordSix", passWord);
                            response.addCookie(Name);
                            response.addCookie(Pwd);
                            //设置session 保存用户名
                            HttpSession session = request.getSession();
                            session.setAttribute("userID", res.getString(1));
                        }
                    }
                }
                jdbcUntil.closeAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String jsonString = js.toString();
            //System.out.println(jsonString);
            PrintWriter out = response.getWriter();
            out.println(jsonString);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
