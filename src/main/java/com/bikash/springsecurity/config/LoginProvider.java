package com.bikash.springsecurity.config;

import com.bikash.springsecurity.entity.ApplicationUser;
import com.bikash.springsecurity.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author Bikash Shah
 */
@Slf4j
public class LoginProvider {

    public static ApplicationUser getApplicationUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            ApplicationUser user = ((AuthApplicationUser) authentication.getPrincipal()).getUser();
            if (user == null) {
                throw new UnauthorizedException(ResponseMsg.failureResponse("Token Not Found"));
            }
            return user;
        } catch (Exception e) {
            log.error("Error, {}", e);
            throw new UnauthorizedException(ResponseMsg.failureResponse("Token Not Found"));
        }
    }

    public static Optional<ApplicationUser> findApplicationUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            ApplicationUser user = ((AuthApplicationUser) authentication.getPrincipal()).getUser();
            if (user == null) {
                return Optional.empty();
            }
            return Optional.ofNullable(user);
        } catch (Exception e) {
            log.error("Error : ", e.getMessage());
            return Optional.empty();
        }
    }
}
