package com.bootcamp.springboot.one.controller;

import com.bootcamp.springboot.one.dao.EwalletAccountDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.model.WalletAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EwalletAccController {
    @Autowired
    EwalletAccountDao wallAccDao;

    @GetMapping(path = "/wallacc/{addr}")
    public CommonResponse<WalletAccount> getWallAcc(@PathVariable(name = "addr") String addr){
        CommonResponse<WalletAccount> commResp = new CommonResponse<>();
        WalletAccount wallacc = wallAccDao.getWalletAcc(addr);
        commResp.setData(wallacc);
        return commResp;
    }

    @GetMapping(path = "/wallaccs")
    public CommonResponse<List<WalletAccount>> getListWallAcc(){
        CommonResponse<List<WalletAccount>> commResp = new CommonResponse<>();
        List<WalletAccount> wallaccs = wallAccDao.getListWalletAcc();
        commResp.setData(wallaccs);
        return commResp;
    }

    @GetMapping(path = "/wallaccs/{keyword}")
    public CommonResponse<List<WalletAccount>> getListWallAccBySearch(@PathVariable(name = "keyword") String keyword){
        CommonResponse<List<WalletAccount>> commResp = new CommonResponse<>();
        List<WalletAccount> wallaccs = wallAccDao.getListWalletAccBySearch(keyword);
        commResp.setData(wallaccs);
        return commResp;
    }

    @PostMapping(path = "/wallacc")
    public CommonResponse<WalletAccount> setWallAcc(@RequestBody WalletAccount wallacc){
        CommonResponse<WalletAccount> commResp = new CommonResponse<>();
        WalletAccount walletAcc = wallAccDao.setWalletAcc(wallacc);
        commResp.setData(wallacc);
        return commResp;
    }

    @PutMapping(path = "/wallacc")
    public CommonResponse<WalletAccount> updateWallAcc(@RequestBody WalletAccount wallacc){
        CommonResponse<WalletAccount> commResp = new CommonResponse<>();
        WalletAccount walletAcc = wallAccDao.updateWalletAcc(wallacc);
        commResp.setData(wallacc);
        return commResp;
    }

    @DeleteMapping(path = "/wallacc/{addr}")
    public  CommonResponse<WalletAccount> delWallAcc(@PathVariable(name = "addr") String addr){
        CommonResponse<WalletAccount> commResp = new CommonResponse<>();
        WalletAccount walletAcc = wallAccDao.delWalletAcc(addr);
        commResp.setData(walletAcc);
        return commResp;
    }
}
