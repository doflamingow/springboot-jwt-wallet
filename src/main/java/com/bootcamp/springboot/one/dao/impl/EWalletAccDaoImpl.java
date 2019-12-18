package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.EwalletAccountDao;
import com.bootcamp.springboot.one.model.WalletAccount;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EWalletAccDaoImpl implements EwalletAccountDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public WalletAccount getWalletAcc(String addr) {
        WalletAccount acc = em.find(WalletAccount.class, addr);
        return acc;
    }

    @Override
    public List<WalletAccount> getListWalletAccBySearch(String keyword) {
        WalletAccount wallacc = new WalletAccount();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<WalletAccount> query = builder.createQuery(WalletAccount.class);
        Root<WalletAccount> root = query.from(WalletAccount.class);

        query.select(root).where(
                builder.or(
                        builder.like(root.get("accNumb"), "%" + keyword + "%"),
                        builder.like(root.get("walletAddress"), "%" + keyword + "%"),
                        builder.like(root.get("walletName"), "%" + keyword + "%"),
                        builder.like(root.get("openDate"), "%" + keyword + "%")
                )
        );
        Query q = em.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<WalletAccount> getListWalletAcc() {
        Query query = em.createQuery("FROM Account");
        return query.getResultList();
    }

    @Transactional
    @Override
    public WalletAccount setWalletAcc(WalletAccount wallacc) {
        WalletAccount walletAccount = new WalletAccount();

        // create account number automatically
        WalletAccount wallAddr = null;
        Query query = em.createQuery("FROM WalletAccount ORDER BY wallet_address DESC");
        query.setMaxResults(1);
        wallAddr = (WalletAccount) query.getSingleResult();
        String wallAddress = "";
        if(wallAddr == null){
            wallAddress = "WA00001";
        } else {
            int lengthWallAddr = wallAddr.getWalletAddress().length();
            String cutAccNum = wallAddr.getWalletAddress().substring(5, lengthWallAddr);
            wallAddress = "WA00" + String.format("%03d", Integer.parseInt(cutAccNum) + 1);
        }

        wallacc.setWalletAddress(wallAddress);

        walletAccount = em.merge(wallacc);

        return walletAccount;
    }

    @Transactional
    @Override
    public WalletAccount updateWalletAcc(WalletAccount wallacc) {
        WalletAccount walletAccount = new WalletAccount();
        walletAccount = em.merge(wallacc);
        return walletAccount;
    }

    @Transactional
    @Override
    public WalletAccount delWalletAcc(String addr) {
        WalletAccount wallacc = em.find(WalletAccount.class, addr);
        em.remove(wallacc);
        return wallacc;
    }
}
