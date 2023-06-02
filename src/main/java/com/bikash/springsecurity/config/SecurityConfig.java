package com.bikash.springsecurity.config;

import com.bikash.springsecurity.config.token.TokenAuthenticationEntryPoint;
import com.bikash.springsecurity.config.token.TokenAuthenticationProvider;
import com.bikash.springsecurity.config.token.TokenAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import static org.springframework.http.HttpStatus.FORBIDDEN;

/**
 * @author Bikash Shah
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        log.info("auth.mode : {}", authMode);
        http
                // Custom JWT based security filter
                .exceptionHandling()
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .headers()
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//                .addFilterBefore();


        http.addFilterBefore(tokenAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    TokenAuthorizationFilter tokenAuthorizationFilter() throws Exception {
        final TokenAuthorizationFilter filter = new TokenAuthorizationFilter(RestPath.JWT_URLS);
        filter.setAuthenticationManager(tokenAuthenticationProvider);
        filter.setAuthenticationSuccessHandler(successHandler());
        filter.setAuthenticationFailureHandler(failureHandler());
        return filter;
    }

    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }
    @Bean
    AuthenticationFailureHandler failureHandler() {
        final AuthenticationFailureHandler failureHandler = new AuthenticationEntryPointFailureHandler(authenticationEntryPoint());
        return failureHandler;
    }
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new TokenAuthenticationEntryPoint();
    }

    @Bean
    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(FORBIDDEN);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
