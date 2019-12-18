package com.bootcamp.springboot.one.dao;

import com.bootcamp.springboot.one.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustByNum(String num);
    Customer getCustByEmail(String email);
    List<Customer> getList();
    Customer setCust(Customer cust);
    Customer updateCust(Customer cust);
    Customer delCust(String num);
    Customer login(Customer cust);
}
