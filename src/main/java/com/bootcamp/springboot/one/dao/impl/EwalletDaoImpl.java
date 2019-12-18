package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.EwalletDao;
import com.bootcamp.springboot.one.model.Wallet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class EwalletDaoImpl implements EwalletDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Wallet> getListWallet() {
        Query query = em.createQuery("FROM Wallet");
        return query.getResultList();
    }

    @Override
    public Wallet getWallet(String id) {
        Wallet wallet = em.find(Wallet.class, id);
        return wallet;
    }
}
