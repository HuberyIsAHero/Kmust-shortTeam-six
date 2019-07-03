package com.six.pojo;

/**
 * 收货人类
 */
public class Receiver {
    private String receiverId;  //收货人id
    private String getReceiverName; //收货人姓名
    private String Sheng;   //收货人省份
    private String Shi; //收货人市
    private String Qu;  //收货人区县
    private String xiangXiDiZhi;    //详细地址
    private String phone;   //收货人电话号

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getGetReceiverName() {
        return getReceiverName;
    }

    public void setGetReceiverName(String getReceiverName) {
        this.getReceiverName = getReceiverName;
    }

    public String getSheng() {
        return Sheng;
    }

    public void setSheng(String sheng) {
        Sheng = sheng;
    }

    public String getShi() {
        return Shi;
    }

    public void setShi(String shi) {
        Shi = shi;
    }

    public String getQu() {
        return Qu;
    }

    public void setQu(String qu) {
        Qu = qu;
    }

    public String getXiangXiDiZhi() {
        return xiangXiDiZhi;
    }

    public void setXiangXiDiZhi(String xiangXiDiZhi) {
        this.xiangXiDiZhi = xiangXiDiZhi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
