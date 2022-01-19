package com.revature.repos;

import com.revature.models.Customer;

import java.util.List;

public interface ClerkDAO {

    public List<Customer> findAllCustomers();

    public Customer findCustomerByID(int customerID);

    public Boolean closeAccount(int customerID);

    public Boolean transferMoney(int accountNumber, int amount);

}
