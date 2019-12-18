package com.bootcamp.springboot.one.config.security;

import com.bootcamp.springboot.one.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

public class UserHit implements UserDetails {
    private static final long serialVersionUID = -6595290709882074455L;

    private Customer customer;
    private Collection authorities;

    public UserHit(Customer customer, Collection authorities){
        this.customer = customer;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getFirstName(){
        if(customer == null){
            return null;
        } else {
            return this.customer.getFirstName();
        }
    }

    @Override
    public String getPassword() {
        if(customer == null){
            return null;
        } else {
            return String.format("{noop}%s", customer.getPassword());
        }
    }

    @Override
    public String getUsername() {
        if(customer == null){
            return null;
        } else {
            return this.customer.getEmail();
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
