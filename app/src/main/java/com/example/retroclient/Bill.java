package com.example.retroclient;

import java.math.BigDecimal;
import java.util.Date;
//import java.time.Instant;

//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

public class Bill
{

    private Integer id;

    private BigDecimal billamount;
    private BigDecimal prevbillamt;
    private BigDecimal payment;
    private BigDecimal adjustment;
    private BigDecimal currcharges;
    private BigDecimal totalamt;
    private Date billdate;
    private Date duedate;

   // @ManyToOne
    //@JoinColumn
    private Owner owner;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public BigDecimal getBillamount() {
        return billamount;
    }


    public void setBillamount(BigDecimal billamount) {
        this.billamount = billamount;
    }


    public BigDecimal getPrevbillamt() {
        return prevbillamt;
    }


    public void setPrevbillamt(BigDecimal prevbillamt) {
        this.prevbillamt = prevbillamt;
    }


    public BigDecimal getPayment() {
        return payment;
    }


    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }


    public BigDecimal getAdjustment() {
        return adjustment;
    }


    public void setAdjustment(BigDecimal adjustment) {
        this.adjustment = adjustment;
    }


    public BigDecimal getCurrcharges() {
        return currcharges;
    }


    public void setCurrcharges(BigDecimal currcharges) {
        this.currcharges = currcharges;
    }


    public BigDecimal getTotalamt() {
        return totalamt;
    }


    public void setTotalamt(BigDecimal totalamt) {
        this.totalamt = totalamt;
    }


    public Date getBilldate() {
        return billdate;
    }


    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }


    public Date getDuedate() {
        return duedate;
    }


    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }


    public Owner getOwner() {
        return owner;
    }


    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return
                "\n"+
                "INVOICE ID : " + id +
                "\n"+
                "Bill Amount = " + billamount +
                "\n"+
                "Previous Bill = " + prevbillamt +
                "\n"+
                "Current Charges = " + currcharges +
                "\n"+
                "Billdate : " + billdate +
                "\n"+
                "Pay till : " + duedate +
                "\n"+
                "Total Amount =" + totalamt +
                "\n"+
                "Paid amount = " + payment +
                "\n";
    }
}

