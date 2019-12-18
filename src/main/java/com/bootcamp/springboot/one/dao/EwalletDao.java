package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.model.Wallet;

import java.util.List;

public interface EwalletDao {
    List<Wallet> getListWallet();
    Wallet getWallet(String id);
}
