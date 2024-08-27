package pojo;

public class DeliveryInformation {
    private String orderid;

    private String sendid;

    private Integer billStatus;

    private Integer disstributionStatus;

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

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Integer getDisstributionStatus() {
        return disstributionStatus;
    }

    public void setDisstributionStatus(Integer disstributionStatus) {
        this.disstributionStatus = disstributionStatus;
    }
}