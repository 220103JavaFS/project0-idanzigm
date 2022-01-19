package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.StrangerDAO;
import com.revature.repos.StrangerDAOImple;

public class StrangerService {
    private StrangerDAO strangerDAO = new StrangerDAOImple();

    public Boolean signUp(Customer customer) {return strangerDAO.signUp(customer);}

}
