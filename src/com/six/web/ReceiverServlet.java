package com.six.web;

import com.alibaba.fastjson.JSONObject;
import com.six.dao.GoodDao;
import com.six.dao.OrderDao;
import com.six.dao.ReceiverDao;
import com.six.pojo.Order;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchao
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @Description TODO
 * @createTime 2019年07月04日 09:14:00
 */
@WebServlet("/receiver")
public class ReceiverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String opType = request.getParameter("opType");
        String orderId = request.getParameter("orderId");
        List list=null;
        if(opType.equals("Receiver")){
            list =ReceiverDao.getReceiverList();

        }else if (opType.equals("getOrder")){
            System.out.println("我进来获取Order了:  "+ orderId);
            list = OrderDao.getOrder(orderId);
        }else if (opType.equals("getGoods")){
            String goodId = request.getParameter("goodId");
            System.out.println("我进来获取Good了");
            try {
                list= new ArrayList();
                list.add(GoodDao.getGood(goodId));
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
        }

        //封装为json
        String jsonString = JSONObject.toJSONString(list);
        System.out.println(jsonString);
        PrintWriter out = response.getWriter();
        out.println(jsonString);
        System.out.println("溜了溜了");

    }
}
