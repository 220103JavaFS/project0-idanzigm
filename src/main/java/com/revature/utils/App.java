package com.revature.utils;

import com.revature.controllers.*;
import io.javalin.Javalin;

public class App {
    public static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create();
        configure(new AdminController(), new ClerkController(), new CustomerController(), new LoginController(), new StrangerController());
        app.start();
    }

    private static void configure(Controller... controllers) {
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }

}
