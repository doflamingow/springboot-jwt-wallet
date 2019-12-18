package com.bootcamp.springboot.one.controller;

import com.bootcamp.springboot.one.dao.CustomerDao;
import com.bootcamp.springboot.one.dto.CommonResponse;
import com.bootcamp.springboot.one.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDao custDao;

//    @Autowired
//    private CustomerRepository custRepo;

    @GetMapping(path = "/customers")
    public CommonResponse<List<Customer>> getAllCust(){
//        List<Customer> listCust = custDao.getList();
//        return listCust;
        CommonResponse<List<Customer>> commResp = new CommonResponse<>();
        List<Customer> listCust = custDao.getList();
        commResp.setData(listCust);
        return commResp;
    }

//    @GetMapping(path = "/customer/{email}")
//    public CommonResponse<Customer> getCustByNum(@PathVariable(name = "id") String num){
//        CommonResponse<Customer> commResp = new CommonResponse<>();
//        Customer cust = custDao.getCustByNum(num);
//        if(cust == null){
//            commResp.setResponseCode("404");
//            commResp.setResponseMessage("Not Found");
//        } else {
//            commResp.setData(cust);
//        }
//        return commResp;

        //        CommonResponse<Customer> commResp = new CommonResponse<>();
//        List<Customer> listCust = getCustomer();
//        for(Customer list : listCust){
//            if(list.getCustomerNumber() == id){
//                commResp.setData(list);
//            } else {
//                commResp.setResponseCode("99");
//                commResp.setResponseMessage("Not Found");
//            }
//        }
//        return commResp;
//    }

    @GetMapping(path = "/customer/{email}")
    public CommonResponse<Customer> getCustByEmail(@PathVariable(name = "email") String email) {
        CommonResponse<Customer> commResp = new CommonResponse<>();
        Customer cust = custDao.getCustByEmail(email);
        if (cust == null) {
            commResp.setResponseCode("404");
            commResp.setResponseMessage("Not Found");
        } else {
            commResp.setData(cust);
        }
        return commResp;
    }

//    @PostMapping(path = "/customer")
//    public List<Customer> setCust(@RequestBody Customer cust){
//        List<Customer> listCust = getCustomer();
//
//        Customer customer = new Customer();
//        customer.setId(cust.getId());
//        customer.setFirstName(cust.getFirstName());
//        customer.setLastName(cust.getLastName());
//        listCust.add(customer);
//
//        return listCust;
//    }
    @PostMapping(path = "/customer/login")
    public CommonResponse<Customer> login(@RequestBody Customer cust) {
        CommonResponse<Customer> commResp = new CommonResponse<>();
        Customer customer = custDao.login(cust);

        if (customer == null) {
            commResp.setResponseCode("404");
            commResp.setResponseMessage("Not Found");
        } else {
            commResp.setData(customer);
        }

        return commResp;
    }

    @PostMapping(path = "/customer")
    public CommonResponse<Customer> setCust(@RequestBody Customer cust){
        CommonResponse<Customer> commResp = new CommonResponse<>();
        Customer customer = custDao.setCust(cust);

        if (customer == null) {
            commResp.setResponseCode("404");
            commResp.setResponseMessage("Not Found");
        } else {
            commResp.setData(customer);
        }

        return commResp;

        //        CommonResponse<List<Customer>> commResp = new CommonResponse<>();
//        List<Customer> listCust = getCustomer();
//
//        Customer customer = new Customer();
//        customer.setCustomerNumber(cust.getCustomerNumber());
//        customer.setFirstName(cust.getFirstName());
//        customer.setLastName(cust.getLastName());
//        listCust.add(customer);
//        commResp.setData(listCust);
//
//        return commResp;
    }

    @PutMapping("/customer")
    public CommonResponse<Customer> updateCust(@RequestBody Customer cust){
        CommonResponse<Customer> commResp = new CommonResponse<>();
        Customer customer = custDao.updateCust(cust);

        if (customer == null) {
            commResp.setResponseCode("404");
            commResp.setResponseMessage("Not Found");
        } else {
            commResp.setData(customer);
        }
        return commResp;
        //        CommonResponse<List<Customer>> commResp = new CommonResponse<>();
//        List<Customer> listCust = getCustomer();
//
//        for(Customer list : listCust){
//            if(list.getCustomerNumber() == id){
//                list.setCustomerNumber(cust.getCustomerNumber());
//                list.setFirstName(cust.getFirstName());
//                list.setLastName(cust.getLastName());
//                commResp.setData(listCust);
//            } else {
//                commResp.setResponseCode("99");
//                commResp.setResponseMessage("Not Found");
//            }
//        }
//        return commResp;
    }

//    @DeleteMapping(path = "/customer/{id}")
//    public CommonResponse<Customer> deleteCustomer(@PathVariable String id){
//        CommonResponse<Customer> commResp = new CommonResponse<>();
//        Customer cust = custDao.delCust(id);
//        commResp.setData(cust);
//        return commResp;
        //        CommonResponse<List<Customer>> commResp = new CommonResponse<>();
//        List<Customer> listCust = getCustomer();
//        for(Customer list : listCust){
//            if(list.getCustomerNumber() == id){
//                list.setCustomerNumber("0");
//                list.setFirstName("");
//                list.setLastName("");
//                commResp.setData(listCust);
//            } else {
//                commResp.setResponseCode("99");
//                commResp.setResponseMessage("Not Found");
//            }
//        }
//        return commResp;
//    }

//    public static List<Customer> getCustomer(){
//        List<Customer> listCust = new ArrayList<>();
//
//        Customer cust1 = new Customer();
//        cust1.setCustomerNumber("1");
//        cust1.setFirstName("riz");
//        cust1.setLastName("ki");
//        listCust.add(cust1);
//
//        Customer cust2 = new Customer();
//        cust2.setCustomerNumber("2");
//        cust2.setFirstName("kus");
//        cust2.setLastName("rana");
//        listCust.add(cust2);
//
//        Customer cust3 = new Customer();
//        cust3.setCustomerNumber("3");
//        cust3.setFirstName("rizki");
//        cust3.setLastName("kusrana");
//        listCust.add(cust3);
//
//        return listCust;
//    }
}
