package com.six.dao;

import com.six.until.DBUntil;

import javax.naming.NamingException;
import java.sql.*;

public class JdbcUntil {
    public Connection con = null;   //数据库连接对象
    public PreparedStatement pstm = null;  //执行动态sql
    public Statement stm = null;    //执行静态sql
    public ResultSet res = null;   //结果集

    /**
     * 构造函数 获取连接池对象
     */
    public JdbcUntil() throws SQLException, NamingException {
        con = DBUntil.getConnectionFromPool();
        stm = con.createStatement();

    }

    /**
     *查询
     * @param sql 查询语句
     * @return 查询结果集
     */
    public ResultSet query(String sql){
        try {
            res = stm.executeQuery(sql);
           /* while (res.next()){
                System.out.println(res.getString(1));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 增删改
     * @param sql 增删改语句
     * @return 受影响行数
     */
    public int executeUpdate(String sql){
        int rows = 0;
        try {
            rows = stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 动态查询
     * @return 结果集
     */
    public ResultSet sysExecuteQuery(){
        try {
            res = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    /**
     * 动态增删改
     * @return 受影响行数
     */
    public int sysExecuteUpdate(){
        int rows = 0;
        try {
            rows = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 关闭所有连接
     */
    public void closeAll(){
        try {
            if (res != null) {
                res.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
