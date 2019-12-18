package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.TransTypeDao;
import com.bootcamp.springboot.one.model.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class TransTypeDaoImpl implements TransTypeDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public TransactionType getTransTypeById(String id) {
        return em.find(TransactionType.class, id);
    }

    @Override
    public List<TransactionType> getListTransType() {
        Query query = em.createQuery("FROM TransactionType");
        return query.getResultList();
    }
}
