package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.model.WalletAccount;

import java.util.List;

public interface EwalletAccountDao {
    List<WalletAccount> getListWalletAcc();
    WalletAccount getWalletAcc(String addr);
    List<WalletAccount> getListWalletAccBySearch(String keyword);
    WalletAccount setWalletAcc(WalletAccount wallacc);
    WalletAccount updateWalletAcc(WalletAccount wallacc);
    WalletAccount delWalletAcc(String addr);
}
