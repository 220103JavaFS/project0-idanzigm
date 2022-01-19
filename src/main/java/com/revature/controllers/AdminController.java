package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.services.AdminService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class AdminController extends Controller {

    private AdminService adminService = new AdminService();

    Handler getEmployees = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
            ctx.json(adminService.findAllEmployees());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getEmployee = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            int employeeID = Integer.parseInt(ctx.pathParam("employeeID")); // a try catch block here would prevent user breakage
            Employee employee = adminService.findEmployeeByID(employeeID);
            ctx.json(employee);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler updateEmployee = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Employee employee = ctx.bodyAsClass(Employee.class);
            if(adminService.changeAccessLevel(employee)){
                ctx.status(202);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler addEmployee = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Employee employee = ctx.bodyAsClass(Employee.class);
            if(adminService.hireClerk(employee)){
                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

//    Handler removeEmployee = (ctx) -> {
//        if(ctx.req.getSession(false)!=null){
//
//            if (true){
//                ctx.status(201);
//            } else {
//                ctx.status(400);
//            }
//        }else{
//            ctx.status(400);
//        }
//    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/employee", getEmployees);
        app.get("employees/{employeeID}", getEmployee);
        app.put("/employee", updateEmployee);
        app.post("/employee", addEmployee);
//        app.post("/employee", removeEmployee);
    }
}
