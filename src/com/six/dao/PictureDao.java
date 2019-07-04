package com.six.dao;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库图片
 */
public class PictureDao {
    /**
     * 获取单张图片
     * @param goodId
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public static String getPic(String goodId) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String pirPre = "com" + goodId + "w";   //图片前缀
        String sql = "select picId from tb_picture where goodId=\"" + goodId + "\" and picId like \"" + pirPre + "1%\"";
        //System.out.println(sql);
        ResultSet res_color = myl.query(sql);
        String color = "";
        while (res_color.next()) {
            color = res_color.getString(1);
        }
        //System.out.println(color);
        myl.closeAll();
        return color;
    }
    /**
     * 通过编号获取所有的预浏览图片
     * @param goodId
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public static List<String> getAllPic(String goodId) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String pirPre = "com"+goodId+"w";   //图片前缀
        String sql = "select picId from tb_picture where goodId=\""+goodId+"\" and picId like \""+pirPre+"%\"";
        System.out.println(sql);
        ResultSet res_color = myl.query(sql);
        ArrayList<String> list = new ArrayList();
        while(res_color.next()){
            String color = res_color.getString(1);
            list.add(color);
        }
        myl.closeAll();
        return  list;
    }

    /**
     * 通过编号获取所有的底部大图
     * @param goodId
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public static List<String> getAllPicF(String goodId) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String pirPre = "com"+goodId+"f";   //图片前缀
        String sql = "select picId from tb_picture where goodId=\""+goodId+"\" and picId like \""+pirPre+"%\"";
        System.out.println(sql);
        ResultSet res_color = myl.query(sql);
        ArrayList<String> list = new ArrayList();
        while(res_color.next()){
            String color = res_color.getString(1);
            list.add(color);
        }
        myl.closeAll();
        return  list;
    }
}
