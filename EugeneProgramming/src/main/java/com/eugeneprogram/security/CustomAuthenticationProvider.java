package com.eugeneprogram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.eugeneprogram.tc.service.TcService;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    //TcService에서 즉 tc 테이블에 있는 id, pw들로 로그인을 해야한다.
    TcService tcService;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        int num = 0;
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        try {
            num = tcService.comparePw(password, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (num > 0) {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
    
    
   
}
