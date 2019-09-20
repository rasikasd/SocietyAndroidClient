package com.example.retroclient;

import java.util.Date;

public class Receipt {

    private Integer	id;
    private Float paidamt;
    private String rcptdate;
    private String paymenttype;
    private String paymentdetail;
    private Owner owner;
    private Bill bill;

    public Receipt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPaidamt() {
        return paidamt;
    }

    public void setPaidamt(Float paidamt) {
        this.paidamt = paidamt;
    }

    public String getRcptdate() {
        return rcptdate;
    }

    public void setRcptdate(String rcptdate) {
        this.rcptdate = rcptdate;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPaymentdetail() {
        return paymentdetail;
    }

    public void setPaymentdetail(String paymentdetail) {
        this.paymentdetail = paymentdetail;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", paidamt=" + paidamt +
                ", rcptdate=" + rcptdate +
                ", paymenttype='" + paymenttype + '\'' +
                ", paymentdetail='" + paymentdetail + '\'' +
                ", owner=" + owner +
                ", bill=" + bill +
                '}';
    }
}
