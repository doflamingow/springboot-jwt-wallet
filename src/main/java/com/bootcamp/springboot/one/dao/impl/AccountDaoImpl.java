package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.AccountDao;
import com.bootcamp.springboot.one.exception.UserException;
import com.bootcamp.springboot.one.model.Account;
import com.bootcamp.springboot.one.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Autowired
    AccountRepository accRepo;

    @PersistenceContext
    private EntityManager em;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Override
    public Account getAccByNum(String num) throws UserException {
        Account acc = em.find(Account.class, num);
        if(acc == null){
            LOGGER.error(String.format("Account %s Not Found", num));
            throw new UserException("422", String.format("Account %s Not Found", num));
        }
//        try{
//acc =  em.find(Account.class, num);
//        } catch (UserException e) {
//            throw new UserException("422", "Account Not Found");
//        }
        return acc;
    }

    @Override
    public List<Account> getListAccSearch(String keyword){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);

        query.select(root).where(
            builder.or(
                builder.like(root.get("accNumber"), "%" + keyword + "%"),
                builder.like(root.get("accName"), "%" + keyword + "%"),
                builder.like(root.get("balance"), "%" + keyword + "%"),
                builder.like(root.get("sDate"), "%" + keyword + "%")
            )
        );

//        Query q = em.createQuery("FROM Account where" +
//                "accNumber LIKE %" + keyword + "% OR" +
//                "accName LIKE %" + keyword + "% OR" +
//                "balance LIKE %" + keyword + "% OR" +
//                "sDate LIKE %" + keyword + "%");
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Account> getListAcc() {
        Query query = em.createQuery("FROM Account");
        return query.getResultList();
    }

    @Transactional
    @Override
    public Account setAcc(Account acc) {
        Account account = new Account();
        // create account number automaticly
        Account accNum = null;
        Query query = em.createQuery("FROM Account ORDER BY account_number DESC");
        query.setMaxResults(1);
        accNum = (Account) query.getSingleResult();
        String accNumb = "";
        if(accNum == null){
            accNumb = "AN00001";
        } else {
            int lengthAccNum = accNum.getAccNumber().length();
            String cutAccNum = accNum.getAccNumber().substring(5, lengthAccNum);
            accNumb = "AN00" + String.format("%03d", Integer.parseInt(cutAccNum) + 1);
        }

        acc.setAccNumber(accNumb);

        account = em.merge(acc);

        return account;
    }

    @Transactional
    @Override
    public Account updateAcc(Account acc) {
        Account account = new Account();
        account = em.merge(acc);
        return account;
    }

    @Transactional
    @Override
    public Account delAcc(String num) {
        Account acc = em.find(Account.class, num);
        em.remove(acc);
        return acc;
    }
}
