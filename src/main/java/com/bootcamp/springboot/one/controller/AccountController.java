package com.bootcamp.springboot.one.controller;

import com.bootcamp.springboot.one.dao.AccountDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.exception.TestException;
import com.bootcamp.springboot.one.exception.UserException;
import com.bootcamp.springboot.one.model.Account;
import com.bootcamp.springboot.one.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountDao accDao;

    @Autowired
    AccountRepository accRepo;

    @GetMapping(path = "/account/{id}")
    public CommonResponse<Account> getAccByNum(@PathVariable(name = "id") String num) throws TestException, UserException {
        CommonResponse<Account> commResp = new CommonResponse<>();
        Account acc = accDao.getAccByNum(num);
        commResp.setData(acc);
        return commResp;
    }

    @GetMapping(path = "/accounts")
    public CommonResponse<List<Account>> getListAcc(){
        CommonResponse<List<Account>> commResp = new CommonResponse<>();
        List<Account> accs = accDao.getListAcc();
        if(accs == null){
            commResp.setResponseCode("99");
            commResp.setResponseMessage("Not Found");
        } else {
            commResp.setData(accs);
        }
        return commResp;
    }

    @GetMapping(path = "/accounts/{keyword}")
    public CommonResponse<List<Account>> getListAccSearch(@PathVariable(name = "keyword") String keyword) throws UserException {
        CommonResponse<List<Account>> commResp = new CommonResponse<>();
        List<Account> accs = accDao.getListAccSearch(keyword);
        if(accs.size() < 1){
            throw new UserException("99", "Not Found");
        } else {
            commResp.setData(accs);
        }
        return commResp;
//        List<Account> accs = accRepo.findByDDateContaining(keyword);
//        commResp.setData(accs);
//        return commResp;
    }

    @PostMapping(path = "/account")
    public CommonResponse<Account> addAcc(@RequestBody Account acc){
        CommonResponse<Account> commResp = new CommonResponse<>();
        Account account = accDao.setAcc(acc);
        commResp.setData(account);
        return commResp;
    }

    @PutMapping(path = "/account")
    public CommonResponse<Account> updateAcc(@RequestBody Account acc){
        CommonResponse<Account> commResp = new CommonResponse<>();
        Account account = accDao.updateAcc(acc);
        commResp.setData(account);
        return commResp;
    }

    @DeleteMapping(path = "/account/{id}")
    public CommonResponse<Account> delAcc(@PathVariable(name = "id") String num){
        CommonResponse<Account> commResp = new CommonResponse<>();
        Account account = accDao.delAcc(num);
        commResp.setData(account);
        return commResp;
    }

}
