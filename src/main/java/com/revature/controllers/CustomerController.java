package com.revature.controllers;

import com.revature.services.ClerkService;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController extends Controller {

    private CustomerService customerService = new CustomerService();

    Handler updatePersonalInfo = (ctx) -> {

    };

    Handler addDeposit = (ctx) -> {

    };

    Handler addWithdrawal = (ctx) -> {

    };

    @Override
    public void addRoutes(Javalin app) {

    }
}
