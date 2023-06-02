package com.bikash.springsecurity.authentication;

import com.bikash.springsecurity.config.ResponseMsg;
import com.bikash.springsecurity.entity.ApplicationUser;
import com.bikash.springsecurity.exception.UnauthorizedException;
import com.bikash.springsecurity.repository.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Bikash Shah
 */
@Slf4j
@Component
public class ApplicationUserManager {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Transactional(readOnly = true)
    public ApplicationUser loadUserByUsername(String userName) {
        Optional<ApplicationUser> user = applicationUserRepository.findByUserName(userName);
        if (user.isPresent()) {
            //valid username
            log.debug("Logged in application user : {}", user.get().getId());
            return user.get();
        }
        throw new UnauthorizedException(ResponseMsg.failureResponse("Invalid Username"));
    }
}
