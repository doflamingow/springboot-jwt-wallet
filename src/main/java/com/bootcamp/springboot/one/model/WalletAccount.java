package com.bootcamp.springboot.one.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_wallet_account")
public class WalletAccount {

    @Id
    @Column(name = "wallet_address")
    private String walletAddress;

    @Column(name = "wallet_name")
    private String walletName;

    @Column(name = "open_date")
    private String openDate;

    @Column(name = "account_number")
    private String accNumb;

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getAccNumb() {
        return accNumb;
    }

    public void setAccNumb(String accNumb) {
        this.accNumb = accNumb;
    }
}
