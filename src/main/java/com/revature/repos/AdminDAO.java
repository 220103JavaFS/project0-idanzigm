package com.revature.repos;

import com.revature.models.Employee;

import java.util.List;

public interface AdminDAO {

    public List<Employee> findAllEmployees();

    public Employee findEmployeeByID(int Employee_ID);

    public Boolean changeAccessLevel(Employee employee);

    public Boolean hireClerk(Employee employee);

    public Boolean fireClerk(int employeeID);
}
