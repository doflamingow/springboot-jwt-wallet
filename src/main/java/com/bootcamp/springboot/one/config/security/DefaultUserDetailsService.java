package com.bootcamp.springboot.one.config.security;

import com.bootcamp.springboot.one.dao.CustomerDao;
import com.bootcamp.springboot.one.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return mockUser(username);
    }

    private UserDetails mockUser(String username){
        try{
            Customer customer = customerDao.getCustByEmail(username);
            if(customer == null){
                throw new EntityNotFoundException("99 Failed");
            }
//            return new User(customer.getEmail(), String.format("{noop}%s", customer.getPassword()), getAuthority());
            return new UserHit(customer, getAuthority());
        } catch (EntityNotFoundException e){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private List getAuthority(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    private String getTime() {return "abc";}
}
