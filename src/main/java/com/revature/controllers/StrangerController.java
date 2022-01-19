package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.StrangerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StrangerController extends Controller {

    StrangerService strangerService = new StrangerService();

    Handler addCustomer = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(strangerService.signUp(customer)){
                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/welcome", addCustomer);
    }
}
