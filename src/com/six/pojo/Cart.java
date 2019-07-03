package com.six.pojo;

/**
 * 购物车类
 */
public class Cart {
    private String userId;  //用户id
    private String goodId;  //商品编号
    private String mingCheng;   //商品名称
    private String yanSe;   //商品颜色
    private String banBen;  //商品版本
    private String danJia;  //商品单价
    private String shuLiang;    //商品数量

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getMingCheng() {
        return mingCheng;
    }

    public void setMingCheng(String mingCheng) {
        this.mingCheng = mingCheng;
    }

    public String getYanSe() {
        return yanSe;
    }

    public void setYanSe(String yanSe) {
        this.yanSe = yanSe;
    }

    public String getBanBen() {
        return banBen;
    }

    public void setBanBen(String banBen) {
        this.banBen = banBen;
    }

    public String getDanJia() {
        return danJia;
    }

    public void setDanJia(String danJia) {
        this.danJia = danJia;
    }

    public String getShuLiang() {
        return shuLiang;
    }

    public void setShuLiang(String shuLiang) {
        this.shuLiang = shuLiang;
    }
}
