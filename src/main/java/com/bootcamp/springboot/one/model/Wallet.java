package com.bootcamp.springboot.one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_wallet")
public class Wallet {

    @Id
    @Column(name = "wallet_id")
    private String walletId;

    @Column(name = "wallet_name")
    private String walletName;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }
}
