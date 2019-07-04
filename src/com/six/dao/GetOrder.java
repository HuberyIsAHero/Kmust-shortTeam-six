/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GetOrder
 * Author:   陆
 * Date:     2019/7/4 0:45
 * Description: 添加order表的数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.six.dao;

import com.six.pojo.Cart;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈添加order表的数据〉
 *
 * @author 陆
 * @create 2019/7/4
 * @since 1.0.0
 */
public class GetOrder {
    public static int getOrder(String user_Id) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String sql = "select * from tb_cart where userId="+user_Id;
        ResultSet res_from_cart = null;
        res_from_cart = myl.query(sql);
        int res=0;
        while (res_from_cart.next()){
             String userId;  //用户id
             String goodId;  //商品编号
            String mingCheng;   //商品名称
             String yanSe;   //商品颜色
             String banBen;  //商品版本
             String danJia;  //商品单价
             String shuLiang;    //商品数量
             String data;
            userId=res_from_cart.getString("userId");
            goodId=res_from_cart.getString("goodId");
            mingCheng=res_from_cart.getString("mingCheng");
            yanSe=res_from_cart.getString("yanSe");
            banBen=res_from_cart.getString("banBen");
            danJia=res_from_cart.getString("danJia");
            shuLiang=res_from_cart.getString("shuLiang");
 //           Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");//设置日期格式
            String time = df.format(new Date());
 //           System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//            date.getTime();
            String sqlorder = "INSERT INTO tb_order(orderId,goodId,userId,receiverId,zhiFuFangShi,dingDanJinE,xiaDanShiJian,dingDanZhuangTai,shuLiang,banben,yanse)";
            sqlorder+=" VALUES ('"+time+"','"+goodId+"','"+userId+"','"+2+"','"+"在线支付"+"','"+danJia+"','"+time+"','"+"在线"+"','"+shuLiang+"','"+banBen+"','"+yanSe+"');";
            //增加order表单的信息
            res=myl.executeUpdate(sqlorder);
            if(res==0){

                System.out.println("res的值为"+res);
                System.out.println("sql的值为"+sqlorder);
                System.out.println("增加order表数据失败");
            }else {
                System.out.println("增加order表数据成功");
            }
        }
        myl.closeAll();
        return res;
    }


}