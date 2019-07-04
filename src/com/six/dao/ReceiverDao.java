package com.six.dao;

import com.six.pojo.Receiver;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchao
 * @version 1.0.0
 * @ClassName ReceiverDao.java
 * @Description TODO
 * @createTime 2019年07月04日 09:22:00
 */
public class ReceiverDao {
    public static List<Receiver> getReceiverList(){
        JdbcUntil myl = null;
        ArrayList result = null;
        try {
            myl = new JdbcUntil();
            String sql = "SELECT * FROM tb_receiver";
            ResultSet res = myl.query(sql);
            result = new ArrayList();
            while (res.next()) {
                String receiverId = res.getString("receiverId");  //收货人id
                String receiverName = res.getString("receiverName"); //收货人姓名
                String Sheng = res.getString("Sheng");   //收货人省份
                String Shi = res.getString("Shi"); //收货人市
                String Qu = res.getString("Qu");  //收货人区县
                String xiangXiDiZhi = res.getString("xiangXiDiZhi");    //详细地址
                String phone = res.getString("phone");   //收货人电话号
                Receiver receiver = new Receiver();
                receiver.setReceiverId(receiverId);
                receiver.setGetReceiverName(receiverName);
                receiver.setSheng(Sheng);
                receiver.setShi(Shi);
                receiver.setQu(Qu);
                receiver.setXiangXiDiZhi(xiangXiDiZhi);
                receiver.setPhone(phone);
                result.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        assert myl != null;
        myl.closeAll();
        return result;
    }
}
