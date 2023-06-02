package com.bikash.springsecurity.authentication;

import com.bikash.springsecurity.config.token.AdminTokenUtil;
import com.bikash.springsecurity.config.ResponseMsg;
import com.bikash.springsecurity.dto.ServerResponse;
import com.bikash.springsecurity.entity.ApplicationUser;
import com.bikash.springsecurity.exception.UnauthorizedException;
import com.bikash.springsecurity.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Bikash Shah
 */
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    PasswordEncoder bcrypt;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private ApplicationUserManager applicationUserManager;
    @Autowired
    private AdminTokenUtil adminTokenUtil;


    @Override
    public ServerResponse login(LoginRequest loginRequest) {
        ServerResponse serverResponse = new ServerResponse();


        ApplicationUser applicationUser = applicationUserManager.loadUserByUsername(loginRequest.getUsername());

        validateCredential(loginRequest,applicationUser);

        // get username from application check valid username check valid credentials
        //check valid application user type

        String token = adminTokenUtil.generateToken(applicationUser.getUsername(),"WEB");


        //Here we can put the token in redis later on.
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(applicationUser.getUsername());
        loginResponse.setFirstName(applicationUser.getLastName());
        loginResponse.setLastName(applicationUser.getLastName());
        loginResponse.setToken(token);

        serverResponse.setSuccess(true);
        serverResponse.setMessage("Login Successfull");
        serverResponse.setObj(loginResponse);
        return serverResponse;
    }

    private void validateCredential(LoginRequest loginRequest,ApplicationUser applicationUser) {
        boolean valid = bcrypt.matches(loginRequest.getPassword(), applicationUser.getPassword());
       // refreshPasswordAttemptCounter(valid);
        if (valid) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(applicationUser, null));
        } else {
            throw new UnauthorizedException(ResponseMsg.failureResponse("Invalid Username Password"));
        }
    }
}
