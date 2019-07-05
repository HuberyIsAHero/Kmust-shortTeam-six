package com.six.web;

import com.six.dao.GetOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetOrderServlet", urlPatterns = "/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
      HttpSession session = request.getSession(true);
      String id = (String)session.getAttribute("userID");
        System.out.println("进入GetOrderServlet函数");
        String res="";
        try{
            res= GetOrder.getOrder(id);

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(res);
        response.sendRedirect("flow2.html" + "?" + "orderId="+res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
