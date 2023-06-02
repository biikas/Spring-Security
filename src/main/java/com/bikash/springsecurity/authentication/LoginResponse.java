package com.bikash.springsecurity.authentication;

import com.bikash.springsecurity.dto.BaseResponse;
import lombok.Data;

/**
 * @author Bikash Shah
 */

@Data
public class LoginResponse extends BaseResponse {


//    private String passwordFlag;
    private String username;
    private String firstName;
    private String lastName;
    private String token;

//    private String name;
//    private String branchName;
//    private String userType;
//    private Integer passwordExpiryDays;
//    private String token;
//    private String accountNumber;
//    private String mobileNumber;
//    private String emailAddress;
//    private String authMode;
//    private List<MenuDTO> roles;
}
