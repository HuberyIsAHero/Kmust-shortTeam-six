/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Cart
 * Author:   陆
 * Date:     2019/7/3 21:03
 * Description: 获取goods信息；对cart表进行数据的添加
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.six.dao;

import com.six.pojo.Cart;
import com.six.pojo.Picutre;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取goods信息；对cart表进行数据的添加〉
 *
 * @author 陆
 * @create 2019/7/3
 * @since 1.0.0
 */


public class Cart1 {
    /**
     * 获取cart购物车的数据；
     */
    public static List<Cart> getGrartList(String user_Id) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String sql = "select * from tb_cart where userId="+user_Id;
        List<Cart> result = new ArrayList<Cart>();
        //       ArrayList result = new ArrayList();
        ResultSet res_from_data = null;
        res_from_data = myl.query(sql);
        while (res_from_data.next()) {
            Cart cart = new Cart();
            cart.setUserId(res_from_data.getString("userId"));
            cart.setGoodId(res_from_data.getString("goodId"));
            cart.setMingCheng(res_from_data.getString("mingCheng"));
            cart.setYanSe(res_from_data.getString("yanSe"));
            cart.setBanBen(res_from_data.getString("banBen"));
            cart.setDanJia(res_from_data.getString("danjia"));
            cart.setShuLiang(res_from_data.getString("shuLiang"));
            result.add(cart);
        }
        myl.closeAll();
        return result;

    }

    public static String[] getPicutre(String user_Id) throws SQLException, NamingException {
        System.out.println("进入getPicutre函数！");
        String[] Pic={};
        int i=0;
        JdbcUntil myl = new JdbcUntil();
        String sql = "select * from tb_cart where userId="+user_Id;
        System.out.println(sql);
  //      List<Picutre> result = new ArrayList<Picutre>();
        ResultSet res_from_data = null;
 //       ResultSet res_from_picture = null;
        res_from_data = myl.query(sql);
        while (res_from_data.next()) {
            String picutre = PictureDao.getPic(res_from_data.getString("goodId"));
            System.out.println(picutre);
            Pic[i]=picutre;
 //           Picutre cart = new Picutre();
//            int GoodId;
//            GoodId=res_from_data.getInt("goodId");
//            String sql1 = "select * from tb_picture where goodId="+GoodId+" AND picId like '____w1%____'";
//            res_from_picture = myl.query(sql1);
//            while (res_from_picture.next()){
//                Picutre picutre = new Picutre();
//                picutre.setGoodId(res_from_picture.getString("goodId"));
//                picutre.setPicId(res_from_picture.getString("picId"));
//                result.add(picutre);
//                System.out.println(picutre.getGoodId());
//            }

        }
        myl.closeAll();
        return Pic;


    }
}