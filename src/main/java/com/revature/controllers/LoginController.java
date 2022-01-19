package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class LoginController extends Controller{

    LoginService loginService = new LoginService();

    private Handler loginAttempt = (ctx) -> {
        UserDTO credentials = ctx.bodyAsClass(UserDTO.class);
        if(loginService.login(credentials.username, credentials.password)){
            ctx.req.getSession();
            ctx.status(200);
            if(ctx.req.getSession(false)!=null){
                Object info = loginService.displayInfo(credentials.username);
                ctx.json(info);
                ctx.status(200);
            }else {
                ctx.status(401);
            }
        }else {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }

    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginAttempt);
    }
}
