package com.revature.controllers;

import com.revature.models.Customer;

import com.revature.services.ClerkService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClerkController extends Controller {

    private ClerkService clerkService = new ClerkService();

    Handler getCustomers = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(clerkService.findAllCustomers());
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    Handler getCustomer = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            int customerID = Integer.parseInt(ctx.pathParam("customerID")); // a try catch block here would prevent user breakage
            Customer customer = clerkService.findCustomerByID(customerID);
            ctx.json(customer);
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

//    Handler closeAccount = (ctx) ->
//        if(ctx.req.getSession(false)!=null){
//
//            if (true){
//                ctx.status(201);
//            } else {
//                ctx.status(400);
//            }
//        }else{
//            ctx.status(400);
//        };

//    Handler makeTransfer = (ctx) -> {
//
//    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/customer", getCustomers);
        app.get("/customer/{customerID}", getCustomer);
    }
}
