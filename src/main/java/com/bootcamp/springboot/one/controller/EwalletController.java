package com.bootcamp.springboot.one.controller;

import com.bootcamp.springboot.one.dao.EwalletDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EwalletController {
    @Autowired
    EwalletDao walletDao;

    @GetMapping(path = "/wallets")
    public CommonResponse<List<Wallet>> getListWallet(){
        CommonResponse<List<Wallet>> commResp = new CommonResponse<>();
        List<Wallet> wallet = walletDao.getListWallet();
        commResp.setData(wallet);
        return commResp;
    }

    @GetMapping(path = "/wallet/{id}")
    public CommonResponse<Wallet> getWalletById(@PathVariable(name = "id") String id){
        CommonResponse<Wallet> commResp = new CommonResponse<>();
        Wallet wallet = walletDao.getWallet(id);
        commResp.setData(wallet);
        return commResp;
    }
}
