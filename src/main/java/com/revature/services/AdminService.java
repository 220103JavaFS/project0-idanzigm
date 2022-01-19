package com.revature.services;

import com.revature.models.Employee;
import com.revature.repos.AdminDAO;
import com.revature.repos.AdminDAOImple;

import java.util.List;

public class AdminService {

    private AdminDAO adminDAO = new AdminDAOImple();

    public List<Employee> findAllEmployees() {
        return adminDAO.findAllEmployees();
    }

    public Employee findEmployeeByID(int ID) {
        return adminDAO.findEmployeeByID(ID);
    }

    public Boolean changeAccessLevel(Employee employee) {
        return adminDAO.changeAccessLevel(employee);
    }

    public Boolean hireClerk(Employee employee) {
        return adminDAO.hireClerk(employee);
    }

    public Boolean fireClerk(int employeeID) {
        return adminDAO.fireClerk(employeeID);
    }
}
