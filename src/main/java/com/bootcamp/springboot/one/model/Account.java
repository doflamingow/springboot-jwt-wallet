package com.bootcamp.springboot.one.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    @Column(name = "account_number")
    private String accNumber;

    @Column(name = "account_name")
    private String accName;

    @Column(name = "pin")
    private int pin;

    @Column(name = "balance")
    private String balance;

//    @Column(name = "open_date")
//    @CreationTimestamp
//    private Date dDate;

    @Column(name = "open_date")
    private String sDate;

    @Column(name = "customer_number")
    private String custNumber;

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


//    public Date getdDate() {
//        return dDate;
//    }
//
//    public void setdDate(Date dDate) {
//        this.dDate = dDate;
//    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }
}
