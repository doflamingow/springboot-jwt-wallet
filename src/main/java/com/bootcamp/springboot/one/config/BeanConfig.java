package com.bootcamp.springboot.one.config;

import com.bootcamp.springboot.one.dao.*;

import com.bootcamp.springboot.one.dao.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class BeanConfig {

    @Bean
    public CustomerDao customerDao(){
        return new CustomerDaoImpl();
    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }

    @Bean
    public TransactionDao transDao(){
        return new TransactionDaoImpl();
    }

    @Bean
    public TransTypeDao transTypeDao(){
        return new TransTypeDaoImpl();
    }

    @Bean
    public EwalletDao walletDao(){
        return new EwalletDaoImpl();
    }

    @Bean
    public EwalletAccountDao walletAccDao(){
        return new EWalletAccDaoImpl();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }
}
