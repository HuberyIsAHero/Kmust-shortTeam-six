package com.six.dao;

import com.six.pojo.Good;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 为ile构造商品列表来创建的数据库操作，针对good表
 */
public class GoodDao {
    /**
     *
     * @return 商品列表
     * @throws SQLException
     * @throws NamingException
     */
    public static List<Good> getGoodList() throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        ResultSet res_good = null;
        String sql = "select * from tb_goods";
        ArrayList result = new ArrayList();
        res_good = myl.query(sql);
        while(res_good.next()){
            String goodId;  //商品编号
            String dingJia; //商品定价
            String benDianJia;  //本店价
            String shangJiaShiJian; //上架时间
            String shangPinPingFen; //商品评分
            String shangPinMingCheng;   //商品名称
            String pinPai;  //商品品牌
            String maoZhonng;   //商品毛重
            String chanDi;  //商品产地
            String xianKa;  //商品显卡
            String chuKong; //商品触控
            String houDu;   //商品厚度
            String chuLiQi; //商品处理器
            String chiCun;  //商品尺寸
            //获取属性
            goodId = res_good.getString("goodId");
            dingJia = res_good.getString("dingJia");
            benDianJia = res_good.getString("benDianJia");
            shangJiaShiJian = res_good.getString("shangJiaShiJian");
            shangPinPingFen = res_good.getString("shangPinPingFen");
            shangPinMingCheng = res_good.getString("shangPinMingCheng");
            pinPai = res_good.getString("pinPai");
            maoZhonng = res_good.getString("maoZhong");
            chanDi = res_good.getString("chanDi");
            xianKa = res_good.getString("xianKa");
            chuKong = res_good.getString("chuKong");
            houDu = res_good.getString("houDu");
            chuLiQi =res_good.getString("chuLiQi");
            chiCun = res_good.getString("chiCun");
            //设置属性
            Good good = new Good();
            good.setBenDianJia(benDianJia);
            good.setChanDi(chanDi);
            good.setChiCun(chiCun);
            good.setHouDu(houDu);
            good.setXianKa(xianKa);
            good.setChiCun(chiCun);
            good.setChuKong(chuKong);
            good.setChuLiQi(chuLiQi);
            good.setMaoZhonng(maoZhonng);
            good.setPinPai(pinPai);
            good.setShangJiaShiJian(shangJiaShiJian);
            good.setShangPinMingCheng(shangPinMingCheng);
            good.setShangPinMingCheng(shangPinMingCheng);
            good.setGoodId(goodId);
            good.setDingJia(dingJia);
            good.setShangPinPingFen(shangPinPingFen);
            //添加对象到列表
            result.add(good);
        }
        myl.closeAll();
        return result;
    }

    /**
     * 返回单个商品的属性信息
     * @param goodid
     * @return
     */
    public static Good getGood(String goodid) throws SQLException, NamingException {
        JdbcUntil myl = new JdbcUntil();
        String sql = "select * from tb_goods where goodId=\""+goodid+"\"";
        ResultSet res_good = myl.query(sql);
        Good good = new Good();
        while(res_good.next()){
            String goodId;  //商品编号
            String dingJia; //商品定价
            String benDianJia;  //本店价
            String shangJiaShiJian; //上架时间
            String shangPinPingFen; //商品评分
            String shangPinMingCheng;   //商品名称
            String pinPai;  //商品品牌
            String maoZhonng;   //商品毛重
            String chanDi;  //商品产地
            String xianKa;  //商品显卡
            String chuKong; //商品触控
            String houDu;   //商品厚度
            String chuLiQi; //商品处理器
            String chiCun;  //商品尺寸
            //获取属性
            goodId = res_good.getString("goodId");
            dingJia = res_good.getString("dingJia");
            benDianJia = res_good.getString("benDianJia");
            shangJiaShiJian = res_good.getString("shangJiaShiJian");
            shangPinPingFen = res_good.getString("shangPinPingFen");
            shangPinMingCheng = res_good.getString("shangPinMingCheng");
            pinPai = res_good.getString("pinPai");
            maoZhonng = res_good.getString("maoZhong");
            chanDi = res_good.getString("chanDi");
            xianKa = res_good.getString("xianKa");
            chuKong = res_good.getString("chuKong");
            houDu = res_good.getString("houDu");
            chuLiQi =res_good.getString("chuLiQi");
            chiCun = res_good.getString("chiCun");
            //设置属性
            good.setBenDianJia(benDianJia);
            good.setChanDi(chanDi);
            good.setChiCun(chiCun);
            good.setHouDu(houDu);
            good.setXianKa(xianKa);
            good.setChiCun(chiCun);
            good.setChuKong(chuKong);
            good.setChuLiQi(chuLiQi);
            good.setMaoZhonng(maoZhonng);
            good.setPinPai(pinPai);
            good.setShangJiaShiJian(shangJiaShiJian);
            good.setShangPinMingCheng(shangPinMingCheng);
            good.setShangPinMingCheng(shangPinMingCheng);
            good.setGoodId(goodId);
            good.setDingJia(dingJia);
            good.setShangPinPingFen(shangPinPingFen);
        }
        myl.closeAll();
        return good;

    }
}
