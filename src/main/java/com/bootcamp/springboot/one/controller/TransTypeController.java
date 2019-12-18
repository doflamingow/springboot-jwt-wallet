package com.bootcamp.springboot.one.controller;

import com.bootcamp.springboot.one.dao.TransTypeDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransTypeController {

    @Autowired
    TransTypeDao transTypeDao;

    @GetMapping(path = "/ttype/{id}")
    public CommonResponse<TransactionType> getTransTypeById(@PathVariable(name = "id") String id){
        CommonResponse<TransactionType> commResp = new CommonResponse<>();
        TransactionType transType = transTypeDao.getTransTypeById(id);
        commResp.setData(transType);
        return commResp;
    }

    @GetMapping(path = "/ttypes")
    public CommonResponse<List<TransactionType>> getListTransType(){
        CommonResponse<List<TransactionType>> commResp = new CommonResponse<>();
        List<TransactionType> transType = transTypeDao.getListTransType();
        commResp.setData(transType);
        return commResp;
    }
}
