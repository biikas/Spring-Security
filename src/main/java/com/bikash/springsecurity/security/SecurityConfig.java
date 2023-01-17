package com.bikash.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bikash Shah
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.httpBasic();
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        return http.build();
//    }
//
//
//    //for custom authentication provider
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.authenticationProvider(authProvider);
//        return authenticationManagerBuilder.build();
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u = new User("bikas", "bikas", "read");
        UserDetails u1 = new User("nitesh","nitesh","write");
        List<UserDetails> users = new ArrayList<>();
        users.add(u);
        users.add(u1);
        return new InMemoryUserDetailService(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
