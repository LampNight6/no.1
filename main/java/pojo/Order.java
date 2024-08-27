package pojo;

public class Order {
    private int  orderid;

    private String userid;

    private String address;

    private String goodsid;

    private String goodsName; // 新增字段
    private Integer sendid;// 新增字段
    private Integer billStatus;// 新增字段
    private Integer distributionStatus;// 新增字段
    private String username;       //新增字段


//    方便用来创建对象
public Order() {
    // 无参构造函数
}

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Order(int orderid, String address, String goodsid, String username) {
        this.orderid = orderid;
        this.address = address;
        this.goodsid = goodsid;
        this.username = username;
    }


    public Order(int orderid, String userid, String address, String goodsid, String goodsName, Integer sendid, Integer billStatus, Integer distributionStatus, String username) {
        this.orderid = orderid;
        this.userid = userid;
        this.address = address;
        this.goodsid = goodsid;
        this.goodsName = goodsName;
        this.sendid = sendid;
        this.billStatus = billStatus;
        this.distributionStatus = distributionStatus;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodName() {
        return goodsName;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Integer getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(Integer distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public void setGoodName(String goodName) {
        this.goodsName = goodName;
    }

    public int  getOrderid() {
        return orderid;
    }

    public Order( String userid, String address, String goodsid) {
        this.userid = userid;
        this.address = address;
        this.goodsid = goodsid;
    }



    public void setOrderid(int  orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }


}