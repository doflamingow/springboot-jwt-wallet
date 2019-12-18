package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.model.TransactionType;

import java.util.List;

public interface TransTypeDao {
    TransactionType getTransTypeById(String id);
    List<TransactionType> getListTransType();
}
