package com.bootcamp.springboot.one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_number_credit")
    private String accNumbCredit;

    @Column(name = "account_number_debit")
    private String accNumbDebit;

    @Column(name = "amount")
    private String amount;

    @Column(name = "date")
    private String date;

    @Column(name = "transaction_type")
    private String transType;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccNumbCredit() {
        return accNumbCredit;
    }

    public void setAccNumbCredit(String accNumbCredit) {
        this.accNumbCredit = accNumbCredit;
    }

    public String getAccNumbDebit() {
        return accNumbDebit;
    }

    public void setAccNumbDebit(String accNumbDebit) {
        this.accNumbDebit = accNumbDebit;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }
}
