package com.revature.repos;

import com.revature.models.Customer;

public interface CustomerDAO {

    public Customer seePersonalInfo(String username);

    public Boolean updatePersonalInfo(Customer customer);

    public Boolean depositMoney(int amount);

    public Boolean withdrawMoney(int amount);

}
