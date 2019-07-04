package com.six.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.six.dao.PictureDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletOrderImage")
public class ServletOrderImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String userID = request.getParameter("userId");
        String goodID = request.getParameter("goodId");
        JSONArray jsonArray = new JSONArray();
        try{
            String imagePath = PictureDao.getPic(goodID);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("imagePath",imagePath);
            jsonArray.add(jsonObject);
        }catch (Exception e){
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
