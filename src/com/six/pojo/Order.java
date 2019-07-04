package com.six.pojo;

/**
 * 订单类
 */
public class Order {
    private String orderId; //订单编号
    private String goodId;  //商品编号
    private String userId;  //用户id
    private String receiverId;   //收货人id
    private String zhiFuFangShi;    //支付方式
    private String zhiFuJinE;   //支付金额
    private String dingDanJinE; //订单金额
    private String xiaDanShiJian;   //下单时间
    private String dingDanZhuangTai;    //订单状态
    private String shuLiang;
    private String banBeng;
    private String yanSe;

    public String getShuLiang() {
        return shuLiang;
    }

    public void setShuLiang(String shuLiang) {
        this.shuLiang = shuLiang;
    }

    public String getBanBeng() {
        return banBeng;
    }

    public void setBanBeng(String banBeng) {
        this.banBeng = banBeng;
    }

    public String getYanSe() {
        return yanSe;
    }

    public void setYanSe(String yanSe) {
        this.yanSe = yanSe;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getZhiFuFangShi() {
        return zhiFuFangShi;
    }

    public void setZhiFuFangShi(String zhiFuFangShi) {
        this.zhiFuFangShi = zhiFuFangShi;
    }

    public String getZhiFuJinE() {
        return zhiFuJinE;
    }

    public void setZhiFuJinE(String zhiFuJinE) {
        this.zhiFuJinE = zhiFuJinE;
    }

    public String getDingDanJinE() {
        return dingDanJinE;
    }

    public void setDingDanJinE(String dingDanJinE) {
        this.dingDanJinE = dingDanJinE;
    }

    public String getXiaDanShiJian() {
        return xiaDanShiJian;
    }

    public void setXiaDanShiJian(String xiaDanShiJian) {
        this.xiaDanShiJian = xiaDanShiJian;
    }

    public String getDingDanZhuangTai() {
        return dingDanZhuangTai;
    }

    public void setDingDanZhuangTai(String dingDanZhuangTai) {
        this.dingDanZhuangTai = dingDanZhuangTai;
    }
}
