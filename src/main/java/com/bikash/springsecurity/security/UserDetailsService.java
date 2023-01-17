package com.bikash.springsecurity.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetailsService extends Serializable {

    String getUsername(); //return user's credentials

    String getPassword(); // ""

    //returns the actions that the app allow user to do as a collection of GrantedAuthority instances
    Collection<? extends GrantedAuthority> getAuthorities();

    //following four methods enable or disable the account for different reasons
    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
/**
 If you choose to implement these user restrictions in your application’s logic, you
 need to override the following methods: isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled(), such that those
 needing to be enabled return true. Not all applications have accounts that expire or
 get locked with certain conditions. If you do not need to implement these functionalities in your application, you can simply make these four methods ret
 **/
}
