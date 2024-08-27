package pojo;

public class Comment {
    private String orderid;

    private String sendid;

    private String userid;

    private String content;

    private String grand;

    public Comment(String orderid, String sendid, String userid, String content,String grand) {
        this.orderid = orderid;
        this.sendid = sendid;
        this.userid = userid;
        this.content = content;
        this.grand=grand;
    }

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

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand;
    }
}