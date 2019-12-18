package com.bootcamp.springboot.one.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        UserHit customer = (UserHit) user;

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put(
                "first_name", customer.getFirstName()
        );
        additionalInfo.put(
                "generated_time", new Date());
//        additionalInfo.put("first_name", authentication.);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(
                additionalInfo);
        return accessToken;
    }
}
