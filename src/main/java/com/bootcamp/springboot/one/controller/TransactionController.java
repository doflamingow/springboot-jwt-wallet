package com.bootcamp.springboot.one.controller;


import com.bootcamp.springboot.one.dao.TransactionDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionDao transDao;

    @GetMapping(path = "/trans/{keyword}")
    public CommonResponse<List<Transaction>> getTransByKeyword(@PathVariable(name = "keyword") String keyword){
        CommonResponse<List<Transaction>> commResp = new CommonResponse<>();
        List<Transaction> trans = transDao.getTransBySearch(keyword);
        commResp.setData(trans);
        return commResp;
    }

    @GetMapping(path = "/trans")
    public CommonResponse<List<Transaction>> getListTrans(){
        CommonResponse<List<Transaction>> commResp = new CommonResponse<>();
        List<Transaction> trans = transDao.getTransactions();
        commResp.setData(trans);
        return commResp;
    }

    @PostMapping(path = "/trans")
    public CommonResponse<Transaction> setTrans(@RequestBody Transaction trans){
        CommonResponse<Transaction> commResp = new CommonResponse<>();
        Transaction transaction = transDao.setTransaction(trans);
        commResp.setData(transaction);
        return commResp;
    }
}
