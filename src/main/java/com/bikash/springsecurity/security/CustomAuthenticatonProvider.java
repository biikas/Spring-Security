//package com.bikash.springsecurity.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
///**
// * @author Bikash Shah
// */
//@Component
//public class CustomAuthenticatonProvider implements AuthenticationProvider {
//
//    private UserDetailsService service;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = String.valueOf(authentication.getCredentials());
//
//        User user = (User) service.loadUserByUsername(username);
//
//        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
//        } else {
//            throw new AuthenticationCredentialsNotFoundException("Error in Authentication");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
//    }
//}
