package pojo;

public class Goods {
    private String goodsid;

    private String goodsname;

    private String storeid;

    private String type;

    private Double size;

    private Integer amount;



    public Goods(String goodsid, String goodsname, String storeid, String type, Double size, Integer amount) {
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.storeid = storeid;
        this.type = type;
        this.size = size;
        this.amount = amount;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}