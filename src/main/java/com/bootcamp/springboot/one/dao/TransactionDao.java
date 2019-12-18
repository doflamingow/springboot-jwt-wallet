package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.model.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getTransBySearch(String keyword);
    List<Transaction> getTransactions();
    Transaction setTransaction(Transaction trans);
}
