package com.bikash.springsecurity.controller;

import com.bikash.springsecurity.authentication.AuthService;
import com.bikash.springsecurity.authentication.LoginRequest;
import com.bikash.springsecurity.authentication.LoginResponse;
import com.bikash.springsecurity.dto.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author Bikash Shah
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@NotNull @RequestBody LoginRequest loginRequest) {
        ServerResponse serverResponse = authService.login(loginRequest);

        LoginResponse loginResponse = (LoginResponse) serverResponse.getObj();
//        loginResponse.setSuccess(serverResponse.isSuccess());
//        loginResponse.setMessage(serverResponse.getMessage());
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.AUTHORIZATION, loginResponse.getToken());

        return new ResponseEntity<>(serverResponse, headers, HttpStatus.OK);
    }
}
