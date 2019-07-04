package com.six.dao;

import com.six.pojo.Order;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchao
 * @version 1.0.0
 * @ClassName OrderDao.java
 * @Description TODO
 * @createTime 2019年07月04日 13:31:00
 */
public class OrderDao {
    public static List<Order> getOrder(String str){
        JdbcUntil myl = null;
        try {
            myl = new JdbcUntil();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        ArrayList result = null;
        String orderId;
        String goodId;
        String userId;
        String receiverId;
        String dingDanJinE;
        String shuLiang;
        String banBeng;
        String yanSe;
        String sql = "SELECT * FROM tb_order WHERE xiaDanShiJian= '"+str+"'";
        ResultSet res = myl.query(sql);
        result = new ArrayList();
        try {
            while (res.next()){
                orderId = res.getString("orderId");
                goodId = res.getString("goodId");
                userId = res.getString("userId");
                receiverId = res.getString("receiverId");
                dingDanJinE = res.getString("dingDanJinE");
                shuLiang = res.getString("shuliang");
                banBeng = res.getString("banben");
                yanSe = res.getString("yanse");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setGoodId(goodId);
                order.setUserId(userId);
                order.setReceiverId(receiverId);
                order.setDingDanJinE(dingDanJinE);
                order.setShuLiang(shuLiang);
                order.setBanBeng(banBeng);
                order.setYanSe(yanSe);
                result.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myl.closeAll();
        return result;
    }
}
