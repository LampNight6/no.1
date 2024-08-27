package org.tg.book.dal.po.mbg;

public class Comment {
    private String orderid;

    private String sendid;

    private String userid;

    private String content;

    private Integer grand;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSendid() {
        return sendid;
    }

    public void setSendid(String sendid) {
        this.sendid = sendid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGrand() {
        return grand;
    }

    public void setGrand(Integer grand) {
        this.grand = grand;
    }
}