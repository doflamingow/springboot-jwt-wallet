package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.TransactionDao;
import com.bootcamp.springboot.one.model.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Transaction> getTransBySearch(String keyword) {
        Transaction trans = new Transaction();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = builder.createQuery(Transaction.class);
        Root<Transaction> root = query.from(Transaction.class);

        query.select(root).where(
                builder.or(
                        builder.like(root.get("transactionId"), "%" + keyword + "%"),
                        builder.like(root.get("accNumbCredit"), "%" + keyword + "%"),
                        builder.like(root.get("accNumbDebit"), "%" + keyword + "%"),
                        builder.like(root.get("amount"), "%" + keyword + "%"),
                        builder.like(root.get("date"), "%" + keyword + "%"),
                        builder.like(root.get("transType"), "%" + keyword + "%")
                )
        );
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getTransactions() {
        Query query = em.createQuery("FROM Transaction");
        return query.getResultList();
    }

    @Transactional
    @Override
    public Transaction setTransaction(Transaction trans) {
        Transaction transaction = new Transaction();

        // create account number automatically
        Transaction transId = null;
        Query query = em.createQuery("FROM Transaction ORDER BY transactionId DESC");
        query.setMaxResults(1);
        transId = (Transaction) query.getSingleResult();
        String transactionId = "";
        if(transId == null){
            transactionId = "WA00001";
        } else {
            int lengthWallAddr = transId.getTransactionId().length();
            String cutTransId = transId.getTransactionId().substring(5, lengthWallAddr);
            transactionId = "WA00" + String.format("%03d", Integer.parseInt(cutTransId) + 1);
        }

        trans.setTransactionId(transactionId);

        transaction = em.merge(trans);

        return transaction;
    }
}
