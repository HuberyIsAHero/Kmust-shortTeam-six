package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.JdbcUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReviseAccountServlet", urlPatterns = "/ReviseAccountServlet")
public class ReviseAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        System.out.println("进入ReviseAccountServlet");
        HttpSession session = request.getSession(true);
        String id = (String)session.getAttribute("userID");
        String name = request.getParameter("name");
        String pwq = request.getParameter("pwq");
        String mail = request.getParameter("mail");
        String date = request.getParameter("date");
        String sex = request.getParameter("sex");
 //       System.out.println("读取数据成功");
        int res=0;
        try{
            JdbcUntil myl = new JdbcUntil();
            String sql1="UPDATE tb_user SET userName='"+name+"',userPassword='"+pwq+"',userSex='"+sex+"',userBirth='"+date+"',userMail='"+mail+"' WHERE userId="+id;
//            String sql="INSERT INTO tb_user(userName,userPassword,userSex,userBirth,userMail) VALUES ('"+name+"','"+pwq+"','"+sex+"','"+date+"','"+mail+"');";
            System.out.println(sql1);
            res = myl.executeUpdate(sql1);
            myl.closeAll();
            if(res!=0){
                System.out.println("读取数据成功");
            }
            else{
                System.out.println("读取数据失败");
            }
        }catch (Exception e){
            System.out.println("出现异常");

        }

 //       String jsonString;
      //  jsonString = JSONObject.toJSONString(res);
   //     System.out.println(jsonString);
        PrintWriter out = response.getWriter();
        out.println(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
