package com.bikash.springsecurity.authentication;

import com.bikash.springsecurity.dto.ServerResponse;

public interface AuthService {

    ServerResponse login(LoginRequest loginRequest);

}
