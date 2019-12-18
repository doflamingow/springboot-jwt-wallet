package com.bootcamp.springboot.one.repository;

import com.bootcamp.springboot.one.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, String> {
//    List<Account> findByAccNumberContainingo(String keyword);
//    List<Account> findByDDateContaining(String keyword);
}
