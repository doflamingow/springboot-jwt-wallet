package com.bootcamp.springboot.one.dao.impl;

import com.bootcamp.springboot.one.dao.CustomerDao;
import com.bootcamp.springboot.one.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager em;

    public List<Customer> getList(){
//        Query query = em.createQuery("FROM Customer");
//        return query.getResultList();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

//        List<Predicate> predicates = new ArrayList<>();
//        Predicate phoneTypeEqual =
//
//        query.select(root).where(builder.equal(root.get("firstName"), "Rizki"));
//        query.select(root).where(
//                builder.or(
//                        builder.equal(root.get("firstName"), "Rizki"),
//                        builder.like(root.get("lastName"), "Kus"),
//                        builder.notEqual(root.get("birthDate"), "1996-05-03")
//                ),
//                builder.and(
//                        builder.or(
//                                builder.equal(root.get("firstName"), "Rizki"),
//                                builder.like(root.get("lastName"), "Kus"),
//                                builder.notEqual(root.get("birthDate"), "1996-05-03")
//                        )
//                )
//        );


        Query q = em.createQuery(query);

        return q.getResultList();
    }

    public Customer getCustByNum(String num) {
        return em.find(Customer.class, num);
    }

    @Override
    public Customer getCustByEmail(String email) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

        query.select(root).where(builder.equal(root.get("email"), email));

        Query q = em.createQuery(query);
        return (Customer) q.getSingleResult();
    }

    @Transactional
    public Customer setCust(Customer cust) {
        Customer customer = new Customer();

        Customer custEmail = getCustByEmail(cust.getEmail());
        System.out.println(custEmail);
        if(cust.getEmail().equals(custEmail.getEmail())){
            System.out.println("success");
            return customer;
        } else {
            // create customer number automaticly
            Customer custNum = null;
            Query query = em.createQuery("FROM Customer ORDER BY customer_number DESC");
            query.setMaxResults(1);
            custNum = (Customer) query.getSingleResult();
            String custNumb = "";
            if(custNum == null){
                custNumb = "CN00001";
            } else {
                int lengthCustNum = custNum.getCustomerNumber().length();
                String cutCustNum = custNum.getCustomerNumber().substring(5, lengthCustNum);
                custNumb = "CN00" + String.format("%03d", Integer.parseInt(cutCustNum) + 1);
            }

            cust.setCustomerNumber(custNumb);
            customer = em.merge(cust);
            return customer;
        }


    }

    @Transactional
    @Override
    public Customer updateCust(Customer cust) {
        Customer customer = new Customer();

        Customer customerEmail = getCustByEmail(cust.getEmail());
        if(customerEmail != null && cust.getPassword().equals(customerEmail.getPassword())){
            customer = em.merge(cust);
            return customer;
        }
        return null;
    }

    @Transactional
    public Customer delCust(String num) {
        Customer cust = em.find(Customer.class, num);
        em.remove(cust);
        return cust;
    }

    @Override
    public Customer login(Customer cust) {
        Customer customerEmail = getCustByEmail(cust.getEmail());
        if(customerEmail != null && cust.getPassword().equals(customerEmail.getPassword())){
            return customerEmail;
        }
        return null;
    }
}
