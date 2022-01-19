package com.revature.repos;

import com.revature.models.UserDTO;

public interface LoginDAO {
    public UserDTO findLogin(String username);
    Object displayInfo(String username);
}
