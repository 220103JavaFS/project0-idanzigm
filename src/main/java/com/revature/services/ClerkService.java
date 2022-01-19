package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.ClerkDAO;
import com.revature.repos.ClerkDAOImple;

import java.util.List;

public class ClerkService {

    private ClerkDAO clerkDAO = new ClerkDAOImple();

    public List<Customer> findAllCustomers() {
        return clerkDAO.findAllCustomers();
    }

    public Customer findCustomerByID(int customerID) {
        return clerkDAO.findCustomerByID(customerID);
    }

    public Boolean closeAccount(int customerID){
        return clerkDAO.closeAccount(customerID);
    }

    public Boolean transferMoney(int accountNumber, int amount){
        return clerkDAO.transferMoney(accountNumber, amount);
    }
}
