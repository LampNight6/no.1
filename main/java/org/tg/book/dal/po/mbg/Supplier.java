package org.tg.book.dal.po.mbg;

import java.util.Date;

public class Supplier {
    private String id;

    private String name;

    private String goodsid;

    private Date suplytime;

    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public Date getSuplytime() {
        return suplytime;
    }

    public void setSuplytime(Date suplytime) {
        this.suplytime = suplytime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}