package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImple;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImple();

    public Boolean updatePersonalInfo(Customer customer){
        return customerDAO.updatePersonalInfo(customer);
    }

    public Boolean depositMoney(int amount){
        return customerDAO.depositMoney(amount);
    }

    public Boolean withdrawMoney(int amount){
        return customerDAO.withdrawMoney(amount);
    }
}
