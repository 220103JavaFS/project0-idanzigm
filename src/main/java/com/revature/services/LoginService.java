package com.revature.services;

import com.revature.models.UserDTO;
import com.revature.repos.LoginDAO;
import com.revature.repos.LoginDAOImple;

import java.util.Base64;

public class LoginService {

    LoginDAO loginAttempt = new LoginDAOImple();

    public boolean login(String givenUsername, String givenPassword) {
        UserDTO storedLogin = loginAttempt.findLogin(givenUsername);
        String storedPassword = storedLogin.getPassword();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] storedPasswordBytes = decoder.decode(storedPassword);
        if (givenPassword.equals(new String (storedPasswordBytes))) {
            return true;
        } else {
            return false;
        }
    }

    public Object displayInfo(String givenUsername) {
        return loginAttempt.displayInfo(givenUsername);
    }
}
