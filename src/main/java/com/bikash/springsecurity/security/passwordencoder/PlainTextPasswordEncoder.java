package com.bikash.springsecurity.security.passwordencoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Bikash Shah
 */

public class PlainTextPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        //lets not change the password we just return it
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        //checks if the two equal strings are equal
        return rawPassword.equals(encodedPassword);
    }
}
