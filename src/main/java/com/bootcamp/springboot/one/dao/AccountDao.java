package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.exception.UserException;
import com.bootcamp.springboot.one.model.Account;

import java.util.List;

public interface AccountDao {
    Account getAccByNum(String num) throws UserException;
    List<Account> getListAcc();
    List<Account> getListAccSearch(String search);
    Account setAcc(Account acc);
    Account updateAcc(Account acc);
    Account delAcc(String num);
}
