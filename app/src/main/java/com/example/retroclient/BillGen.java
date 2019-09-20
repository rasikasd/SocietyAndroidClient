package com.example.retroclient;

import java.util.Date;

public class BillGen {

    private Integer id;
    private String billgenstart;
    private String billgenend;
    private Integer totalgenbill;
    private Integer billfreq;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillgenstart() {
        return billgenstart;
    }

    public void setBillgenstart(String billgenstart) {
        this.billgenstart = billgenstart;
    }


    public String getBillgenend() {
        return billgenend;
    }

    public void setBillgenend(String billgenend) {
        this.billgenend = billgenend;
    }

    public Integer getTotalgenbill() {
        return totalgenbill;
    }

    public void setTotalgenbill(Integer totalgenbill) {
        this.totalgenbill = totalgenbill;
    }

    public Integer getBillfreq() {
        return billfreq;
    }

    public void setBillfreq(Integer billfreq) {
        this.billfreq = billfreq;
    }

    @Override
    public String toString() {
        return "BillGen{" +
                "id=" + id +
                ", billgenstart='" + billgenstart + '\'' +
                ", billgenend='" + billgenend + '\'' +
                ", totalgenbill=" + totalgenbill +
                ", billfreq=" + billfreq +
                '}';
    }
}
