package com.example.retroclient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


//import javax.persistence.CascadeType;
//import javax.persistence.OneToMany;

import static java.sql.Types.NULL;

public class Owner {

    private String firstname;
    private String lastname;
    private String flatno;
    private int id;



    public Owner(int id , String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.id=id;
    }

    public Owner() {

    }

    //@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Bill> bills = new HashSet<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFlatno() {
        return flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", flatno='" + flatno + '\'' +
                ", id=" + id +
                ", bills=" + bills +
                '}';
    }

    public Bill getBill(){

        Set<Bill> billset = getBills();

            Integer maxid = 0;
            if (!billset.isEmpty()) {
                for (Bill b : billset) {
                    if (maxid < b.getId()) {
                        maxid = b.getId();
                    }
                }
                for(Bill b: billset) {
                    if (b.getId() == maxid) {
                        return b;
                    }
                }
            }
                return null;
    }
    /* @Override
    public String toString() {
        return "Owner{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", flatno='" + flatno + '\'' +
                ", id=" + id +
                '}';
    }
    */
}
